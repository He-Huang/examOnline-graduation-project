package com.exam.dao;

import com.exam.entity.PaperManage;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface PaperManageDao extends JpaRepository<PaperManage,Integer> {
    List<PaperManage> findAll();

    @Query(value = "select paper_id, question_type,question_id from paper_manage where paper_id = ?",nativeQuery = true)
    List<PaperManage> findAllById(Integer paperId);


}
