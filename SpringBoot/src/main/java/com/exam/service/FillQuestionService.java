package com.exam.service;

import com.exam.entity.FillQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/28 - 14:24
 */
public interface FillQuestionService {

    List<FillQuestion> findByIdAndType(Integer paperId);

    Page<AnswerVO> findAllFill(Pageable page);

    Integer findLastQuestionId();

    FillQuestion add(FillQuestion fillQuestion);

    List<Integer> findBySubject(String subject, Integer pageNo);
}
