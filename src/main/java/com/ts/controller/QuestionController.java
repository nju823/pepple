package com.ts.controller;

import com.ts.dto.ResponseDto;
import com.ts.dto.UploadQuestionInputDto;
import com.ts.model.Question;
import com.ts.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by cong on 2017-11-15.
 * 试题管理
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 批量导入问题
     * @param input
     * @return
     */
    @RequestMapping(value = "/question/upload",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto uploadQuestion(@RequestBody @Valid UploadQuestionInputDto input, HttpServletRequest request){
        ResponseDto responseDto=null;
        try{
            input.setPath(request.getServletContext().getRealPath("/")+input.getPath());
            System.out.println(input.getPath());
            responseDto=questionService.uploadQuestion(input);
        }catch (Exception e){
            e.printStackTrace();
            responseDto=ResponseDto.buildFailure(e.getLocalizedMessage());
        }
        return responseDto;
    }

    @RequestMapping(value = "/question/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto addQuestion(@RequestBody List<Question> questions){
        ResponseDto responseDto=null;
        try{
            responseDto=questionService.addQuestions(questions);
        }catch (Exception e){
            e.printStackTrace();
            responseDto=ResponseDto.buildFailure(e.getLocalizedMessage());
        }
        return responseDto;
    }

    @RequestMapping(value = "/question/query/{courseId}/{num}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto queryQuestions(@PathVariable("courseId") Integer courseId,@PathVariable("num") Integer num){


        return questionService.queryQuestions(courseId, num);
    }

    @RequestMapping(value = "/question/result/query",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getQuestionResult(){


        return null;
    }


}
