package com.exam.serviceimpl;

import com.exam.entity.JudgeQuestion;
import com.exam.dao.JudgeQuestionDao;
import com.exam.service.JudgeQuestionService;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {

    @Autowired
    private JudgeQuestionDao judgeQuestionDao;

    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionDao.findByIdAndType(paperId);
    }

    @Override
    public Page<AnswerVO> findAllJudge(Pageable page) {
        return judgeQuestionDao.findAllJudge(page);
    }

    @Override
    public Integer findLastQuestionId() {
        return judgeQuestionDao.findLastQuestionId();
    }

    @Override
    public JudgeQuestion add(JudgeQuestion judgeQuestion) {
        return judgeQuestionDao.save(judgeQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return judgeQuestionDao.findBySubject(subject,pageNo);
    }
}
