package com.exam.dao;

import com.exam.entity.ExamManage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:12
 */
@Repository
public interface ExamManageDao extends JpaRepository<ExamManage,Integer>, JpaSpecificationExecutor<ExamManage> {
    //分页查询所有考试信息
    Page<ExamManage> findAll(Pageable page);

    //通过试卷id查询考试信息,使用简单的sql语句查询
    @Query(value = "select paper_id from exam_manage order by paper_id desc limit 1",nativeQuery = true )
    Integer findOnlyPaperId();
}
