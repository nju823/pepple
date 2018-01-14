package com.ts.service.email;

import com.ts.model.Email;
import com.ts.dto.ResponseDto;

/**
 * Created by cong on 2017-11-13.
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param email
     * @return
     */
    public ResponseDto sendEmail(Email email);

    /**
     * 异步发送邮件
     * @param email
     * @return
     */
    public ResponseDto sendEmailAsync(Email email);

}
