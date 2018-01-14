package com.ts.service.user;

import com.ts.dto.ResponseDto;

/**
 * Created by cong on 2017-11-19.
 * 验证用户身份服务
 */
public interface UserValidateService {


    /**
     * 通过教师工号验证是否是教师
     * @param teacherId
     * @return
     */
    public ResponseDto isTeacher(String teacherId);


}
