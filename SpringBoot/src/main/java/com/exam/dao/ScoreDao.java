package com.exam.dao;

import com.exam.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface ScoreDao extends JpaRepository<Score,Integer> {
    List<Score> findAll();

    @Query(value = "select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score where student_id = ?",nativeQuery =true)
    List<Score> findAllById(Integer studentId);

    /**
     * @return 查询每位学生的学科分数。返回一个存储学生学科成绩的数组
     */
    @Query(value = "select max(et_score) from score where exam_code = ? group by student_id",nativeQuery = true)
    List<Number> findByExamCode(Integer examCode);
}
