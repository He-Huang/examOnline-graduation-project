package com.exam.dao;
import java.util.List;

import com.exam.entity.JudgeQuestion;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:12
 */
@Repository
public interface JudgeQuestionDao extends JpaRepository<JudgeQuestion,Integer> {
    //分页查询
    @Query(value = "select new com.exam.vo.AnswerVO(q.question,q.subject,q.score,q.level,q.questionType) from JudgeQuestion q")
    Page<AnswerVO> findAllJudge(Pageable page);

    @Query(value = "select question_id from judge_question order by question_id desc limit 1",nativeQuery =true)
    Integer findLastQuestionId();

    //根据类型和id查找
    @Query(value = "select * from judge_question where question_id in (select question_id from paper_manage where question_type = 3 and paper_id = ?)",nativeQuery =true)
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    //根据科目查询判断题
    @Query(value="select question_id from judge_question  where subject=?1  order by rand() desc limit ?2",nativeQuery = true)
    List<Integer> findBySubject(String subject,Integer pageNo);
}
