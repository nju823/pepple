package com.ts.model;

public class FronEndAnswer {
    private int id;
    private String description;
    private int questionId;
    private boolean isRight;
    private boolean isChosen;

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

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }


    public boolean getRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public boolean getChosen() {
        return isChosen;
    }

    public void setIsChosen(boolean isChosen) {
        this.isChosen = isChosen;
    }
}
