package com.exam.serviceimpl;

import com.exam.dao.ExamManageDao;
import com.exam.entity.ExamManage;
import com.exam.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    private ExamManageDao examManageDao;

    @Override
    public List<ExamManage> findAll() {
        return examManageDao.findAll();
    }

    @Override
    public Page<ExamManage> findAll(Pageable page) {
        return examManageDao.findAll(page);
    }

    @Override
    public Optional<ExamManage> findById(Integer examCode) {
        return examManageDao.findById(examCode);
    }

    @Override
    public int delete(Integer examCode) {
        examManageDao.deleteById(examCode);
        return 0;
    }

    @Override
    public ExamManage update(ExamManage exammanage) {
        return examManageDao.save(exammanage);
    }

    @Override
    public ExamManage add(ExamManage exammanage) {
        return examManageDao.save(exammanage);
    }

    //仅通过试卷id查询考试信息
    @Override
    public Integer findOnlyPaperId() {
        return examManageDao.findOnlyPaperId();
    }
}
