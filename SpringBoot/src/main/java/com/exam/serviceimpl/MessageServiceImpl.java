package com.exam.serviceimpl;

import com.exam.dao.MessageDao;
import com.exam.entity.Message;
import com.exam.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Page<Message> findAll(Pageable page) {
        return messageDao.findAll(page);
    }

    @Override
    public Optional<Message> findById(Integer id) {
        return messageDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        messageDao.deleteById(id);
    }

    @Override
    public int update(Message message) {
        return messageDao.update(message);
    }

    @Override
    public Message add(Message message) {
        return messageDao.save(message);
    }
}
