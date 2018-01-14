package com.ts.model;

import org.hibernate.validator.constraints.NotBlank;


/**
 * 用户信息
 */
public class User {

    private int id;

    /**
     * 姓名
     */
    @NotBlank
    private String name;

    /**
     * 学号
     */
    @NotBlank
    private String schoolId;

    /**
     * 邮箱
     */
    @NotBlank
    private String email;

    /**
     * 密码
     */
    @NotBlank
    private String password;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 年级
     */
    private String grade;

    /**
     * 是否已激活，未激活不能登录
     */
    private boolean active;

    /**
     * 邮箱验证的token
     */
    private String token;


    /**
     * 是否是教师
     */
    private int isTeacher;

    public int getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(int isTeacher) {
        this.isTeacher = isTeacher;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
