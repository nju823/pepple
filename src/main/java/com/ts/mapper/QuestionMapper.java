package com.ts.mapper;

import com.ts.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cong on 2017-11-16.
 */
@Repository
public interface QuestionMapper {


    public void addQuestions(List<Question> list);

    public List<Question> queryQuestions(@Param("courseId") Integer courseId, @Param("num") Integer num);
}
