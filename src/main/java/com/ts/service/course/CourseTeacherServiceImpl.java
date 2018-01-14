package com.ts.service.course;

import com.ts.dto.CourseTeacherInputDto;
import com.ts.dto.ResponseDto;
import com.ts.mapper.CourseTeacherMapper;
import com.ts.model.CourseTeacher;
import com.ts.service.user.UserValidateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2017-11-20.
 */
@Service
public class CourseTeacherServiceImpl implements CourseTeacherService{


    @Autowired
    private UserValidateService userValidateService;

    @Autowired
    private CourseTeacherMapper mapper;

    @Override
    public ResponseDto addCourseTeacher(CourseTeacherInputDto input) {

        String isTeacher=(String)userValidateService.isTeacher(input.getTeacherId()).getContent();

        if(!"true".equals(isTeacher))
            return ResponseDto.buildFailure("非教师用户不能为课程添加教师");

        CourseTeacher courseTeacher=new CourseTeacher();
        BeanUtils.copyProperties(input,courseTeacher);
        mapper.addCourseTeacher(courseTeacher);

        return ResponseDto.buildSuccess();
    }

    @Override
    public ResponseDto deleteCourseTeacher(CourseTeacherInputDto input) {
        CourseTeacher courseTeacher=new CourseTeacher();
        BeanUtils.copyProperties(input,courseTeacher);
        mapper.deleteCourseTeacher(courseTeacher);
        return ResponseDto.buildSuccess();
    }

    @Override
    public List<Integer> getTeacherCourses(String teacherId) {
        return mapper.getTeacherCourses(teacherId);
    }


}
