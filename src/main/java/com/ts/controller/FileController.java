package com.ts.controller;

import com.ts.dto.ResponseDto;
import com.ts.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by cong on 2017-11-15.
 */
@Controller
public class FileController {


    @Autowired
    private FileService fileService;

    /**
     * 上传单Excel文件
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto upload(@RequestParam("file")MultipartFile file, @RequestParam("fileType")String fileType, HttpServletRequest request){
        return fileService.upload(file, fileType, request);
    }

    @RequestMapping(value = "/file/download",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto download(@RequestParam("filename")String filename, @RequestParam("fileType")String fileType, HttpServletRequest request, HttpServletResponse response){

        return fileService.download(filename, fileType, request, response);
    }

    @RequestMapping(value = "/file/test",method = RequestMethod.POST)
    @ResponseBody
    public String download(HttpServletRequest request){

        System.out.println(request.getSession().getServletContext().getRealPath("/upload/" + "question" + "/" + "abx.xls"));
        return "ass";
    }


}
