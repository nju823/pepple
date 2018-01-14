package com.ts.controller;

import com.ts.dto.CourseTeacherInputDto;
import com.ts.dto.ResponseDto;
import com.ts.service.course.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by cong on 2017-11-19.
 */
@Controller
public class CourseTeacherController {

    @Autowired
    private CourseTeacherService service;

    @RequestMapping(value = "/course/teacher/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto addCourseTeacher(@RequestBody @Valid CourseTeacherInputDto input){
        ResponseDto responseDto=null;
        try {
            responseDto=service.addCourseTeacher(input);
        }catch (Exception e){
            responseDto=ResponseDto.buildFailure("添加课程失败:"+e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value = "/course/teacher/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto deleteCourseTeacher(@RequestBody @Valid CourseTeacherInputDto input){
        ResponseDto responseDto=null;
        try {
            responseDto=service.deleteCourseTeacher(input);
        }catch (Exception e){
            responseDto=ResponseDto.buildFailure("删除课程失败:"+e.getMessage());
        }
        return responseDto;
    }

}
