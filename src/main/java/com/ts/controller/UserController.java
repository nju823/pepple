package com.ts.controller;

import com.ts.dto.LoginInputDto;
import com.ts.dto.ResponseDto;
import com.ts.model.User;
import com.ts.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto register(@RequestBody @Valid User user){
        ResponseDto responseDto=null;
        try {
            responseDto=userService.register(user);
        }catch (Exception e){
            return ResponseDto.buildFailure(e.getMessage());
        }
        return responseDto;
    }


    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseDto login(@RequestBody @Valid LoginInputDto input){
        ResponseDto responseDto=null;
        try{
            responseDto=userService.login(input);
        }catch (Exception e){
            responseDto=ResponseDto.buildFailure(e.getMessage());
        }
        return responseDto;
    }

    /**
     * 激活邮箱
     * @param token
     * @param email
     * @return
     */
    @RequestMapping(value = "/user/email/send",method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto sendActivateMail(String email){
        return userService.sendActivateMail(email);
    }


    /**
     * 激活邮箱
     * @param token
     * @param email
     * @return
     */
    @RequestMapping(value = "/activatemail",method = RequestMethod.GET)
    @ResponseBody
    public String activeEmail(String token,String email){
        return userService.activeEmail(token,email);
    }
}