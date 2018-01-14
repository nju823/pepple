package com.ts.model;

/**
 * Created by cong on 2017-11-15.
 */
public class Question {

    private Integer id;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 正确答案，可能有多个，用@@分开
     */
    private String answer;

    /**
     * 备选答案，包括正确答案，可能有多个，用@@分开
     */
    private String alternativeAnswer;

    /**
     * 所属课程id
     */
    private Integer courseId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAlternativeAnswer() {
        return alternativeAnswer;
    }

    public void setAlternativeAnswer(String alternativeAnswer) {
        this.alternativeAnswer = alternativeAnswer;
    }
}
