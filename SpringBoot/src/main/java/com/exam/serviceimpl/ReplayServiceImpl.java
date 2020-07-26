package com.exam.serviceimpl;

import com.exam.entity.Replay;
import com.exam.dao.ReplayDao;
import com.exam.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplayServiceImpl implements ReplayService {

    @Autowired
    private ReplayDao replayDao;

    @Override
    public List<Replay> findAll() {
        return replayDao.findAll();
    }

    @Override
    public List<Replay> findAllById(Integer messageId) {
        return replayDao.findAllById(messageId);
    }

    @Override
    public Optional<Replay> findById(Integer replayId) {
        return replayDao.findById(replayId);
    }

    @Override
    public int delete(Integer replayId) {
        return replayDao.delete(replayId);
    }

    @Override
    public Replay update(Replay replay) {
        return replayDao.save(replay);
    }

    @Override
    public Replay add(Replay replay) {
        return replayDao.save(replay);
    }
}
