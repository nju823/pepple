package com.ts.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by cong on 2017-11-19.
 */
public class CourseTeacherInputDto {

    /**
     * 教师的工号
     */
    @NotBlank
    private String teacherId;

    /**
     * 课程id
     */
    @NotNull
    private Integer courseId;

    /**
     * 操作人工号
     */
    private String userId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
