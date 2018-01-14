package com.ts.dto;

import java.util.List;

public class QuestionDto {

    private Integer id;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 备选答案，包括正确答案，可能有多个,以列表的形式保存
     */
    private List<String> alternativeAnswerList;

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


    public List<String> getAlternativeAnswerList() {
        return alternativeAnswerList;
    }

    public void setAlternativeAnswerList(List<String> alternativeAnswerList) {
        this.alternativeAnswerList = alternativeAnswerList;
    }
}
