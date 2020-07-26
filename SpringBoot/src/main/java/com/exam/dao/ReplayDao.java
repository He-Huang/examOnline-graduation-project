package com.exam.dao;

import com.exam.entity.Replay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface ReplayDao extends JpaRepository<Replay, Integer> {
    List<Replay> findAll();

    @Query(value = "select message_id,replay_id,replay,replay_time from replay where message_id = ?",nativeQuery = true)
    List<Replay> findAllById(Integer messageId);

    Optional<Replay> findById(Integer messageId);

    @Query(value = "delete from replay where replay_id = ?",nativeQuery =true)
    int delete(Integer replayId);

}
