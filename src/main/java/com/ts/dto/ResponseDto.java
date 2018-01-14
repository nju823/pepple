package com.ts.dto;

/**
 * Created by cong on 2017-11-13.
 * rest调用的返回值
 */
public class ResponseDto {

    /**
     * 调用是否成功
     */
    private boolean success;

    /**
     * 返回的提示信息
     */
    private String message;

    /**
     * 内容
     */
    private Object content;

    public static ResponseDto buildSuccess(){
        ResponseDto response=new ResponseDto();
        response.setSuccess(true);
        return response;
    }

    public static ResponseDto buildFailure(String message){
        ResponseDto response=new ResponseDto();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
