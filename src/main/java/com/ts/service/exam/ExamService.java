package com.ts.service.exam;

import com.ts.dto.ResponseDto;
import com.ts.model.Exam;

public interface ExamService {


    /**
     * 老师创建考试
     * @param exam
     * @return
     */
    public ResponseDto createExam (Exam exam);

    /**
     * 生成考试试卷
     * @param exam
     * @return
     */
    public ResponseDto createExamPaper (Exam exam);

}

