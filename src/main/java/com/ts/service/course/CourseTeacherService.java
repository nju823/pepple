package com.ts.service.course;


import com.ts.dto.CourseTeacherInputDto;
import com.ts.dto.ResponseDto;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

import java.util.List;

/**
 * Created by cong on 2017-11-20.
 */
public interface CourseTeacherService {

    /**
     * 添加课程的教师
     * @param input
     * @return
     */
    public ResponseDto addCourseTeacher(CourseTeacherInputDto input);

    /**
     * 删除教师的课程
     */
    public ResponseDto deleteCourseTeacher(CourseTeacherInputDto input);

    /**
     * 查询教师的课程
     * @param teacherId
     * @return
     */
    public List<Integer> getTeacherCourses(String teacherId);


}
