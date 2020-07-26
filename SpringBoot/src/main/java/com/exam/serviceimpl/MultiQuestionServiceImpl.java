package com.exam.serviceimpl;

import com.exam.entity.MultiQuestion;
import com.exam.dao.MultiQuestionDao;
import com.exam.service.MultiQuestionService;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {

    @Autowired
    private MultiQuestionDao multiQuestionDao;
    @Override
    public List<MultiQuestion> findByIdAndType(Integer PaperId) {
        return multiQuestionDao.findByIdAndType(PaperId);
    }

    @Override
    public Page<AnswerVO> findAllMulti(Pageable page) {
        return multiQuestionDao.findAllMulti(page);
    }

    @Override
    public MultiQuestion findLastQuestionId() {
        return multiQuestionDao.findLastQuestionId();
    }

    @Override
    public MultiQuestion add(MultiQuestion multiQuestion) {
        return multiQuestionDao.save(multiQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return multiQuestionDao.findBySubject(subject,pageNo);
    }
}
