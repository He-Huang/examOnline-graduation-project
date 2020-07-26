package com.exam.service;

import com.exam.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MessageService {
    Page<Message> findAll(Pageable page);

    Optional<Message> findById(Integer id);

    void delete(Integer id);

    int update(Message message);

    Message add(Message message);


}
