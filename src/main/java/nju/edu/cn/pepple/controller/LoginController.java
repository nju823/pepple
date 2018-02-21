package nju.edu.cn.pepple.controller;


import nju.edu.cn.pepple.dto.LoginDto;
import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private LoginService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseDto login(@RequestBody @Valid LoginDto input){
        return userService.login(input);
    }

}