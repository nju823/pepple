package com.ts.service.file;

import com.ts.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Service
public class FileServiceImpl implements FileService {

    /**
     * 上传文件
     * @param file 文件
     * @param fileType 文件类型
     * @param request
     * @return
     */
    @Override
    public ResponseDto upload(MultipartFile file, String fileType, HttpServletRequest request) {
        String filePath = null;
        ResponseDto dto = null;

        try {
            // 判断文件是否为空
            if (!file.isEmpty()) {
                // 文件保存路径
                filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + fileType + "/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                dto = ResponseDto.buildSuccess();
                dto.setContent(filePath);
            } else {
                dto = ResponseDto.buildFailure("The file is empty...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            dto = ResponseDto.buildFailure(e.toString());
        }

        return dto;
    }

    /**
     * 下载文件
     * @param filename 文件名
     * @param fileType 文件类型
     * @param request
     * @param response
     * @return
     */
    @Override
    public ResponseDto download(String filename, String fileType, HttpServletRequest request, HttpServletResponse response) {
        ResponseDto dto = null;

        //设置文件MIME类型
        response.setContentType(request.getSession().getServletContext().getMimeType(filename));
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径
        String fullFileName = request.getSession().getServletContext().getRealPath("/upload/" + fileType + "/" + filename);
        //System.out.println(fullFileName);
        try {
            //读取文件，考虑试题可能很多，使用缓冲
            InputStream in = new BufferedInputStream(new FileInputStream(fullFileName));
            OutputStream out = new BufferedOutputStream(response.getOutputStream());

            byte[] buffer = new byte[in.available()];
            in.read(buffer);  //读取文件流
            response.reset();//重置结果集

            //输出文件
            out.write(buffer);
            dto = ResponseDto.buildSuccess();

            in.close();   //关闭输入流
            out.close();   //关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
            dto = ResponseDto.buildFailure(e.toString());
        }

        return dto;
    }
}
