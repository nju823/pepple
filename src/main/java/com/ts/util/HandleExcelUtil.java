package com.ts.util;

import com.alibaba.fastjson.JSONObject;
import com.ts.model.Question;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class HandleExcelUtil {

    /**
     * 将Excel文件读取为json字符串组成的list
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public <T> List<T> readXlsToJson(String path,Class<T> clazz) throws Exception {
        List<List<String>> xlsList = readXls(path);

        List<T> result= new ArrayList<T>();
        List<String> subjectList = xlsList.get(0);

        for (int i = 1; i < xlsList.size(); i++) {
            JSONObject jsonObject = new JSONObject(true);
            for (int j = 0; j < xlsList.get(i).size(); j++){
                jsonObject.put(subjectList.get(j), xlsList.get(i).get(j));
//                System.out.println(jsonObject.toString());
            }
            result.add(JSONObject.parseObject(jsonObject.toString(),clazz));
        }

        return result;
    }

    /**
     * 将Excel文件读取为二维字符串数组
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public List<List<String>> readXls(String path) throws Exception {
        Workbook book = null;
        book = getExcelWorkbook(path);
        Sheet sheet = getSheetByNum(book,0);

        int lastRowNum = sheet.getLastRowNum();

        List<List<String>> result = new ArrayList<List<String>>();

        //遍历每一行
        for(int i = 0 ; i <= lastRowNum ; i++){
            Row row = null;
            row = sheet.getRow(i);
            List<String> rowList = new ArrayList<String>();
            if( row != null ){
//                System.out.println("reading line is " + i);
                int lastCellNum = row.getLastCellNum();
//                System.out.println("lastCellNum is " + lastCellNum );
                Cell cell = null;
                //遍历每一列
                for( int j = 0 ; j <= lastCellNum ; j++ ){
                    cell = row.getCell(j);
                    if( cell != null ){
                        String cellValue = getStringVal(cell);
                        rowList.add(cellValue);
//                        System.out.println("cell value is \n" + cellValue);
                    }
                }
            }
            result.add(rowList);
        }
        return result;
    }

    /**
     * 获取Sheet
     * @param book
     * @param number
     * @return
     */
    private  Sheet getSheetByNum(Workbook book,int number){
        Sheet sheet = null;
        try {
            sheet = book.getSheetAt(number);
//          if(sheet == null){
//              sheet = book.createSheet("Sheet"+number);
//          }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return sheet;
    }

    /**
     * 获取Workbook
     * @param filePath
     * @return
     * @throws IOException
     */
    private  Workbook getExcelWorkbook(String filePath) throws IOException {
        Workbook book = null;
        File file  = null;
        FileInputStream fis = null;

        try {
            file = new File(filePath);
            if(!file.exists()){
                throw new RuntimeException("文件不存在");
            }else{
                fis = new FileInputStream(file);
                book = WorkbookFactory.create(fis);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if(fis != null){
                fis.close();
            }
        }
        return book;
    }

    /**
     * 将单元格元素内容转换为String型
     * @param cell
     * @return
     */
    public String getStringVal(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    public static void main(String[] args) throws Exception{
        List<Question> jsonList = new HandleExcelUtil().readXlsToJson("2016.xlsx",Question.class);
        System.out.println(jsonList.size()+" "+jsonList.get(0).getDescription());
    }
}
