package com.ts.service.question;

import com.ts.dto.QuestionDto;
import com.ts.dto.ResponseDto;
import com.ts.dto.UploadQuestionInputDto;
import com.ts.mapper.QuestionMapper;
import com.ts.model.Question;
import com.ts.util.HandleExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017-11-16.
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerAnalysisService answerAnalysisService;

    @Autowired
    private HandleExcelUtil excelUtil;

    @Override
    public ResponseDto addQuestions(List<Question> questions) {
        questionMapper.addQuestions(questions);
        return ResponseDto.buildSuccess();
    }

    @Override
    public ResponseDto uploadQuestion(UploadQuestionInputDto input) {

        ResponseDto responseDto=null;
        List<Question> questions=new ArrayList<Question>();
        try {
            questions=excelUtil.readXlsToJson(input.getPath(),Question.class);
            for(Question question:questions){
                question.setCourseId(input.getCourseId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.buildFailure("解析文件出错:"+e.getMessage());
        }

        if(questions.size()>0)
            responseDto=addQuestions(questions);
        else
            responseDto=ResponseDto.buildFailure("文件为空");

        return responseDto;
    }

    @Override
    public ResponseDto queryQuestions(Integer courseId, Integer num) {
        ResponseDto dto = null;
        List<Question> questionList = new ArrayList<Question>();
        List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
        questionList = questionMapper.queryQuestions(courseId, num);
        if (questionList.size() == 0||questionList.size() < num) {
            dto = ResponseDto.buildFailure("考题数量不足");
        } else {
            System.out.println("查询到的数量为："+questionList.size());
            for (Question q:questionList) {
                questionDtoList.add(questionToDto(q));
            }
            dto = ResponseDto.buildSuccess();
        }
        dto.setContent(questionDtoList);
        return dto;
    }

    private QuestionDto questionToDto(Question q) {
        QuestionDto dto = new QuestionDto();
        dto.setId(q.getId());
        dto.setCourseId(q.getCourseId());
        dto.setDescription(q.getDescription());
        dto.setAlternativeAnswerList(answerAnalysisService.getAnswer(q.getAlternativeAnswer()));
        return dto;
    }
}
