package com.exam.dao;

import com.exam.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:12
 */
@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {
    //

    Page<Message> findAll(Pageable page);

    Optional<Message> findById(Integer id);

    @Query(value = "update message set title = :#{#message.title}, content = :#{#message.content}, time = :#{#message.time} where id = :#{#message.id}", nativeQuery = true)
    @Modifying
    @Transactional
    int update(@Param("message") Message message);

//    @Query(value = "INSERT into message(title, content, message_time) values(:#{#message.title},:#{#message.content},:#{#message.time})",nativeQuery = true)
//    @Modifying
//    @Transactional
//    int add(@Param("message")Message message);

}
