package com.ts.model;

/**
 * Created by cong on 2017-11-13.
 */
public class Email {

    private String receiveMail;        //接收人邮箱
    private String subject;            //标题
    private String content;            //内容

    public Email createNewEmail(String receiveMail, String subject, String content) {
        Email e = new Email();
        e.receiveMail = receiveMail;
        e.subject = subject;
        e.content = content;
        return e;
    }

    public String getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
