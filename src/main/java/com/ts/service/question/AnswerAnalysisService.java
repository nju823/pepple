package com.ts.service.question;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cong on 2017-11-15.
 * 答案保存时将答案用@@分开,需要进行string和list之间的转换
 */

public interface AnswerAnalysisService {


    /**
     * 将字符串解析成答案列表
     * @param s
     * @return
     */
    public List<String> getAnswer(String s);

    /**
     * 将答案列表拼接成字符串
     * @param list
     * @return
     */
    public String getAnswer(List<String> list);

}
