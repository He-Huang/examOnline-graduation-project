package com.exam.service;

import com.exam.entity.Replay;

import java.util.List;
import java.util.Optional;

public interface ReplayService {

    List<Replay> findAll();

    List<Replay> findAllById(Integer messageId);

    Optional<Replay> findById(Integer replayId);

    int delete(Integer replayId);

    Replay update(Replay replay);

    Replay add(Replay replay);
}
