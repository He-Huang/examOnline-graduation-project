package com.exam.dao;

import com.exam.entity.FillQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:12
 */
//填空题
@Repository
public interface FillQuestionDao extends JpaRepository<FillQuestion, Integer> {

    @Query(value = "select * from fill_question where question_id in (select question_id from paper_manage where question_type = 2 and paper_id = ?)",nativeQuery = true)
    List<FillQuestion> findByIdAndType(Integer paperId);

    @Query(value = "select new com.exam.vo.AnswerVO(q.question,q.subject,q.score,q.level,q.questionType) from FillQuestion q")
    Page<AnswerVO> findAllFill(Pageable page);

    //查询最后一条questionId
    @Query(value = "select question_id from fill_question order by question_Id desc limit 1", nativeQuery = true)
    Integer findLastQuestionId();

    @Query(value = "select questionId from fill_question where subject = ? order by rand() desc limit ?",nativeQuery = true)
    List<Integer> findBySubject(String subject,Integer pageNo);
}
