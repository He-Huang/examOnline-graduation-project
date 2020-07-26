package com.exam.service;

import com.exam.entity.Score;

import java.lang.reflect.Array;
import java.util.List;

public interface ScoreService {
    Score add(Score score);

    List<Score> findAll();

    List<Score> findAllById(Integer studentId);

    List<Number> findByExamCode(Integer examCode);
}
