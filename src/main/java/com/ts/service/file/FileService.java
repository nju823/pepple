package com.ts.service.file;

import com.ts.dto.ResponseDto;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zt on 2017-11-16.
 */
public interface FileService {

    //上传文件
    public ResponseDto upload(MultipartFile file, String fileType, HttpServletRequest request);

    //下载文件
    public ResponseDto download(String filename, String fileType, HttpServletRequest request, HttpServletResponse response);

}
