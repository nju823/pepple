package com.ts.service.user;

import com.ts.dto.LoginInputDto;
import com.ts.dto.ResponseDto;
import com.ts.model.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    /**
     * 注册
     * @param user
     * @return
     */
    public ResponseDto register(User user);

    /**
     * 通过学号或邮箱登录
     * @param input
     * @return
     */
    public ResponseDto login(LoginInputDto input) throws NoSuchAlgorithmException;

    /**
     * 激活邮箱
     * @param token
     * @param email
     * @return
     */
    public String activeEmail(String token,String email);

    /**
     * 发送验证邮件
     * @param u
     * @return
     */
    public ResponseDto sendActivateMail(String userEmail);
}
