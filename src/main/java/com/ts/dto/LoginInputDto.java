package com.ts.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by cong on 2017-11-15.
 */
public class LoginInputDto {

    /**
     * 登录名，可以是邮箱或学号
     */
    @NotBlank
    private String username;

    /**
     * 密码
     */
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
