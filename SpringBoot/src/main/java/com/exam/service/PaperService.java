package com.exam.service;

import com.exam.entity.PaperManage;
import com.exam.vo.AnswerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaperService {

    List<PaperManage> findAll();

    List<PaperManage> findAllById(Integer paperId);

    PaperManage add(PaperManage paperManage);

}
