package com.exam.service;

import com.exam.entity.ExamManage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExamManageService {

    /**
     * 不分页查询所有考试信息
     */
    List<ExamManage> findAll();
    Page<ExamManage> findAll(Pageable page);

    Optional<ExamManage> findById(Integer examCode);

    int delete(Integer examCode);

    ExamManage update(ExamManage exammanage);

    ExamManage add(ExamManage exammanage);

    //通过试卷的id查询考试信息
    Integer findOnlyPaperId();
}
