package com.exam.serviceimpl;

import com.exam.entity.FillQuestion;
import com.exam.dao.FillQuestionDao;
import com.exam.service.FillQuestionService;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/4/5 - 20:32
 */
@Service
public class FillQuestionServiceImpl implements FillQuestionService {
    @Autowired
    private FillQuestionDao fillQuestionDao;

    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionDao.findByIdAndType(paperId);
    }

    @Override
    public Page<AnswerVO> findAllFill(Pageable page) {
        return fillQuestionDao.findAllFill(page);
    }

    @Override
    public Integer findLastQuestionId() {
        return fillQuestionDao.findLastQuestionId();
    }

    @Override
    public FillQuestion add(FillQuestion fillQuestion) {
        return fillQuestionDao.save(fillQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return fillQuestionDao.findBySubject(subject,pageNo);
    }
}
