package com.exam.service;

import com.exam.entity.JudgeQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JudgeQuestionService {

    List<JudgeQuestion> findByIdAndType(Integer paperId);

    Page<AnswerVO> findAllJudge(Pageable page);

    Integer findLastQuestionId();

    JudgeQuestion add(JudgeQuestion judgeQuestion);

    List<Integer> findBySubject(String subject,Integer pageNo);
}
