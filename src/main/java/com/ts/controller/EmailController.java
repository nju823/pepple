package com.ts.controller;

import com.ts.model.Email;
import com.ts.dto.ResponseDto;
import com.ts.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cong on 2017-11-13.
 */
@Controller
public class EmailController {

    @Autowired
    public EmailService emailService;
    /**
     * 发送邮件
     * @return
     */
    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public @ResponseBody  ResponseDto sendEmail(@RequestBody  Email email) {

        return emailService.sendEmail(email);
    }


    /**
     * 异步发送邮件
     * @return
     */
    @RequestMapping(value = "/sendEmail/async",method = RequestMethod.POST)
    public @ResponseBody  ResponseDto sendEmailAsync(@RequestBody  Email email) {

        return emailService.sendEmailAsync(email);
    }



}
