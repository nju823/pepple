package com.ts.service.question;

import com.ts.dto.QuestionDto;
import com.ts.dto.ResponseDto;
import com.ts.dto.UploadQuestionInputDto;
import com.ts.model.Question;

import java.util.List;

/**
 * Created by cong on 2017-11-16.
 */
public interface QuestionService {


    /**
     * 添加试题
     * @param questions
     * @return
     */
    public ResponseDto addQuestions(List<Question> questions);

    /**
     * 批量导入试题
     * @param input
     * @return
     */
    public ResponseDto uploadQuestion(UploadQuestionInputDto input);

    /**
     * 随机获取一定数量的试题
     * @param num
     * @return
     */
    public ResponseDto queryQuestions(Integer courseId,Integer num);


}
