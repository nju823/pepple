package com.ts.mapper;

import com.ts.model.Course;

import java.util.List;

/**
 * Created by cong on 2017-11-18.
 */
public interface CourseMapper {

    public void addCourse(Course course);

    public Course getCourseById(Integer id);

    public List<Course> getCoursesById(List<Integer> courseIds);

    public List<Course> getCourseByName(String name);

}
