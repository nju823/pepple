package com.ts.model;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Created by zt at 2017/11/21
 */
public class Exam {

    private Integer id;                            //考试编号

    private Integer questionNum;                   //考题数量

    private Integer score;                         //分值

    private Date startTime;                         //开始时间 yyyy-MM-dd hh:mm:ss

    private Date endTime;                           //结束时间

    private Integer courseId;                       //课程编号

    private String teacherId;                      //创建该考试的教师编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public String getJsonString (Exam exam) {
        String json = JSON.toJSONString(exam);
        return json;
    }
}
