package com.exam.serviceimpl;

import com.exam.entity.Score;
import com.exam.dao.ScoreDao;
import com.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;
    @Override
    public Score add(Score score) {
        return scoreDao.save(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreDao.findAll();
    }

    @Override
    public List<Score> findAllById(Integer studentId) {
        return scoreDao.findAllById(studentId);
    }

    @Override
    public List<Number> findByExamCode(Integer examCode) {
        return scoreDao.findByExamCode(examCode);
    }
}
