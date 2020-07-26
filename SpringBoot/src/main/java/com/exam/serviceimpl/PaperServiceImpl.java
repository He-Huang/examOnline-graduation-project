package com.exam.serviceimpl;

import com.exam.entity.PaperManage;
import com.exam.dao.PaperManageDao;
import com.exam.service.PaperService;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperManageDao paperManageDao;
    @Override
    public List<PaperManage> findAll() {
        return paperManageDao.findAll();
    }

    @Override
    public List<PaperManage> findAllById(Integer paperId) {
        return paperManageDao.findAllById(paperId);
    }

    @Override
    public PaperManage add(PaperManage paperManage) {
        return paperManageDao.save(paperManage);
    }

}
