package com.ts.controller;

import com.ts.dto.ResponseDto;
import com.ts.model.Exam;
import com.ts.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zt at 2017/11/22
 */

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/exam/create", method = RequestMethod.POST)
    public @ResponseBody ResponseDto createExam (@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @RequestMapping(value = "/exam/createPaper", method = RequestMethod.POST)
    public @ResponseBody ResponseDto createExamPaper (@RequestBody Exam exam) {
        return examService.createExamPaper(exam);
    }
}
