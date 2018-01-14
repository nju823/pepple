package com.ts.model;

import java.util.List;

public class FrontEndQuestion {
    private int id;
    private String description;
    private int courseId;
    private boolean isMulti;

    private List<FronEndAnswer> answers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean getMulti() {
        return isMulti;
    }

    public void setIsMulti(boolean isMulti) {
        this.isMulti = isMulti;
    }

    public List<FronEndAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<FronEndAnswer> answers) {
        this.answers = answers;
    }
}
