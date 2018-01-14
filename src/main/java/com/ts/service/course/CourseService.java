package com.ts.service.course;

import com.ts.dto.CourseDto;
import com.ts.dto.ResponseDto;

/**
 * Created by cong on 2017-11-18.
 */
public interface CourseService {

    /**
     * 添加课程
     * @param course
     * @return
     */
    public ResponseDto addCourse(CourseDto course);

    /**
     * 获取教师参与的课程
     * @param teacherId
     * @return
     */
    public ResponseDto getTeacherCourses(String teacherId);

    /**
     * 根据课程名称模糊查询
     * @param name
     * @return
     */
    public ResponseDto searchCoursesByName(String name);

}
