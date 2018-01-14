package com.ts.mapper;

import com.ts.model.CourseTeacher;

import java.util.List;

/**
 * Created by cong on 2017-11-20.
 */
public interface CourseTeacherMapper {

    public void addCourseTeacher(CourseTeacher model);

    public void deleteCourseTeacher(CourseTeacher model);

    /**
     * 获取与教师的所有课程
     * @param teacherId
     * @return
     */
    public List<Integer> getTeacherCourses(String teacherId);

}
