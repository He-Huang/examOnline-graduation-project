package com.exam.dao;

import com.exam.entity.MultiQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface MultiQuestionDao extends JpaRepository<MultiQuestion, Integer> {

    //根据id和类型，查找选择题
    @Query(value = "select * from multi_question where question_id in (select question_id from paper_manage where question_type = 1 and paper_id = ?)",nativeQuery =true)
    List<MultiQuestion> findByIdAndType(Integer PaperId);

    @Query(value = "select new com.exam.vo.AnswerVO(q.question,q.subject,q.score,q.level,q.questionType) from MultiQuestion q")
    Page<AnswerVO> findAllMulti(Pageable page);

    @Query(value = "select question_id from multi_question order by question_id desc limit 1",nativeQuery =true)
    MultiQuestion findLastQuestionId();

    @Query(value = "select question_id from multi_question  where subject =?1 order by rand() desc limit ?2",nativeQuery =true)
    List<Integer> findBySubject(String subject,Integer pageNo);

}
