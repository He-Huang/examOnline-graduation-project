package com.exam.service;

import com.exam.entity.MultiQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MultiQuestionService {

    List<MultiQuestion> findByIdAndType(Integer PaperId);

    Page<AnswerVO> findAllMulti(Pageable page);

    MultiQuestion findLastQuestionId();

    MultiQuestion add(MultiQuestion multiQuestion);

    List<Integer> findBySubject(String subject,Integer pageNo);
}
