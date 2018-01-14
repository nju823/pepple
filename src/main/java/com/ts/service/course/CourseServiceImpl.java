package com.ts.service.course;

import com.ts.dto.CourseDto;
import com.ts.dto.ResponseDto;
import com.ts.mapper.CourseMapper;
import com.ts.mapper.CourseTeacherMapper;
import com.ts.model.Course;
import com.ts.model.CourseTeacher;
import com.ts.service.user.UserValidateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by cong on 2017-11-18.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper mapper;

    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Autowired
    private UserValidateService userService;

    @Override
    public ResponseDto addCourse(CourseDto courseDto) {
        String isTeacher=(String)userService.isTeacher(courseDto.getOwnerId()).getContent();
        if("false".equals(isTeacher)){
            return ResponseDto.buildFailure("非教师用户不能创建课程");
        }
        Course course=new Course();
        BeanUtils.copyProperties(courseDto,course);
        mapper.addCourse(course);
        ResponseDto responseDto=ResponseDto.buildSuccess();
        responseDto.setContent(course.getId());

        //将课程与创建者关联
        CourseTeacher courseTeacher=new CourseTeacher();
        courseTeacher.setCourseId(course.getId());
        courseTeacher.setTeacherId(courseDto.getOwnerId());
        courseTeacherMapper.addCourseTeacher(courseTeacher);

        return responseDto;
    }

    @Override
    public ResponseDto getTeacherCourses(String teacherId) {
        List<Integer> courseIds=courseTeacherMapper.getTeacherCourses(teacherId);
        if(CollectionUtils.isEmpty(courseIds)){
            ResponseDto responseDto=ResponseDto.buildFailure("还没有参加课程");
            return  responseDto;
        }

        List<Course> courses=mapper.getCoursesById(courseIds);
        ResponseDto responseDto=ResponseDto.buildSuccess();
        responseDto.setContent(courses);
        return responseDto;
    }

    @Override
    public ResponseDto searchCoursesByName(String name) {
        if(StringUtils.isEmpty(name))
            return ResponseDto.buildFailure("课程名称不能为空");
        List<Course> list=mapper.getCourseByName(name);
        if(CollectionUtils.isEmpty(list))
            return ResponseDto.buildFailure("查不到课程");
        ResponseDto responseDto=ResponseDto.buildSuccess();
        responseDto.setContent(list);
        return responseDto;
    }


}
