package com.ts.service.user;

import com.ts.dto.LoginInputDto;
import com.ts.mapper.UserMapper;
import com.ts.model.Email;
import com.ts.dto.ResponseDto;
import com.ts.model.User;
import com.ts.service.email.EmailService;
import com.ts.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SecurityUtil securityUtil;

    private String url="http://localhost:8080/ts";

    private Executor executor= Executors.newSingleThreadExecutor();

    @Override
    public ResponseDto register(User user) {
        ResponseDto responseDto=null;

        try {
            user.setPassword(securityUtil.md5(user.getPassword()));
            userMapper.addUser(user);
        }catch (Exception e){
            String message="新增用户失败，请重试";
            e.printStackTrace();
            return ResponseDto.buildFailure(message);
        }

        try{
            responseDto=sendActivateMail(user.getEmail());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.buildFailure("发送验证邮箱失败:"+e.getLocalizedMessage());
        }

        return ResponseDto.buildSuccess();
    }

    @Override
    public ResponseDto login(LoginInputDto input) throws NoSuchAlgorithmException {
        String password=securityUtil.md5(input.getPassword());
        String username=input.getUsername();

        User user=null;
        if(username.contains("@")){//通过邮箱登录
            user=userMapper.getUserByEmail(username);
        }else{//通过学号登录
            user=userMapper.getUserByStudentId(username);
        }

        if(user==null)
            return ResponseDto.buildFailure("用户不存在");

        if(!user.getActive())
            return ResponseDto.buildFailure("用户邮箱未激活");

        String realPassword=user.getPassword();

        if(!realPassword.equals(password))
            return ResponseDto.buildFailure("密码错误");
        ResponseDto responseDto=ResponseDto.buildSuccess();
        responseDto.setContent(user.getIsTeacher());
        return responseDto;
    }

    @Override
    public String activeEmail(String token, String email) {
        User user=userMapper.getUserByEmail(email);
        if(token==null||!token.equals(user.getToken()))
            return "active failure";
        userMapper.activeUser(email);
        return "active success";
    }


    /**
     * 发送激活邮件
     * @param
     * @return
     * @throws NoSuchAlgorithmException
     */
    public ResponseDto sendActivateMail(String userEmail){
        //注册邮箱
        String to  = userEmail;
        //当前时间戳
        Long curTime = System.currentTimeMillis();

        //激活码--用于激活邮箱账号
        String token = to+curTime;
        try {
            token = securityUtil.md5(token);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return ResponseDto.buildFailure("加密密码错误:"+e.getLocalizedMessage());
        }

        //发送的邮箱内容
        String content = "<p>您好 O(∩_∩)O~~<br><br>欢迎加入在线考试网!<br><br>帐户需要激活才能使用，赶紧激活成为加入在线考试网正式的一员吧:)<br><br>请在24小时内点击下面的链接立即激活帐户："
                +"<br><a href='"+url+"/activatemail/?token="+token+"&email="+to+"'>"
                +url+"/activatemail/?token="+token+"&email="+to+"</a></p>";

        Email email=new Email();
        email.setContent(content);
        email.setReceiveMail(userEmail);
        email.setSubject("在线考试网邮箱激活");

        emailService.sendEmailAsync(email);
        //设置验证的token
        userMapper.updateToken(token,userEmail);
        return ResponseDto.buildSuccess();
    }
}
