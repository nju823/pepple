package com.ts.service.user;

import com.ts.dto.ResponseDto;
import com.ts.mapper.UserMapper;
import com.ts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by cong on 2017-11-19.
 */
@Controller
public class UserValidateServiceImpl implements UserValidateService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public ResponseDto isTeacher(String teacherId) {
        ResponseDto responseDto=ResponseDto.buildSuccess();

        User user=userMapper.getUserByStudentId(teacherId);

        if(user==null){
            responseDto.setContent("false");
            responseDto.setContent("用户不存在");
            return responseDto;
        }

        if(!user.getActive()||user.getIsTeacher()!=1){
            responseDto.setContent("false");
            return responseDto;
        }

        responseDto.setContent("true");
        return responseDto;
    }
}
