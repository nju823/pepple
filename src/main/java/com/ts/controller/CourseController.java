package com.ts.controller;

import com.ts.dto.CourseDto;
import com.ts.dto.ResponseDto;
import com.ts.service.course.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;

/**
 * Created by cong on 2017-11-18.
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/course/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto addCourse(@Valid @RequestBody CourseDto courseDto){
        ResponseDto responseDto=null;
        try{
            responseDto=courseService.addCourse(courseDto);
        }catch(Exception e){
            responseDto=ResponseDto.buildFailure(e.getLocalizedMessage());
        }

        return responseDto;
    }

    @RequestMapping(value = "/course/teacher/{teacherId}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto getTeacherCourses(@PathVariable("teacherId") String teacherId){
        return courseService.getTeacherCourses(teacherId);
    }

    @RequestMapping(value = "/course/{name}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto searchCoursesByName(@PathVariable("name") String name){
        return courseService.searchCoursesByName(name);
    }


}
