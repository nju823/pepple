package com.ts.model;

/**
 * Created by cong on 2017-11-20.
 * 课程和教师关系
 */
public class CourseTeacher {

    private String teacherId;

    private Integer courseId;

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
}
