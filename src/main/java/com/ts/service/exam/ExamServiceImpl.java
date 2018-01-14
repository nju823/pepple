package com.ts.service.exam;

import com.ts.dto.ResponseDto;
import com.ts.mapper.ExamMapper;
import com.ts.model.Exam;
import com.ts.service.course.CourseTeacherService;
import com.ts.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CourseTeacherService courseTeacherService;

    @Autowired
    private ExamMapper examMapper;

    @Override
    public ResponseDto createExam(Exam exam) {
        String teacherId = exam.getTeacherId();
        ResponseDto dto = null;
        if (teacherId == null){
            dto = ResponseDto.buildFailure("教师Id为空");
            return dto;
        }
        if (exam.getStartTime().getTime() >= exam.getEndTime().getTime()) {
            dto = ResponseDto.buildFailure("开始时间要早于结束时间");
            return dto;
        }
        if (!courseTeacherService.getTeacherCourses(teacherId).contains(exam.getCourseId())) {
            dto = ResponseDto.buildFailure("教师没有教授这门课程");
            return dto;
        }

        try {
            examMapper.addExam(exam);
            dto = ResponseDto.buildSuccess();
        } catch (Exception e) {
            dto = ResponseDto.buildFailure("添加考试失败： "+e.getMessage());
        }
        return dto;
    }

    @Override
    public ResponseDto createExamPaper(Exam exam) {
        ResponseDto dto = null;
        dto  = questionService.queryQuestions(exam.getCourseId(), exam.getQuestionNum());    //返回试题list
        return dto;
    }

    public static void main(String[] args) throws Exception {
        Exam exam = new Exam();
        exam.setQuestionNum(3);
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        exam.setStartTime(dateFormat2.parse("2017-11-28 10:00:00"));
        exam.setEndTime(dateFormat2.parse("2017-11-28 12:00:00"));
        exam.setCourseId(2);
        exam.setTeacherId("222");
        System.out.println("exam对象的json string: "+exam.getJsonString(exam));
    }
}
