package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.Message;
import com.exam.serviceimpl.MessageServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    //    Sort sort=new Sort(Sort.Direction.DESC,"message_time");
    @GetMapping("/messages/{page}/{size}")
    public ApiResult<Message> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        //实现根据时间倒序排序，同时分页查询
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        PageRequest pageable = PageRequest.of(page, size, sort);
        Page<Message> all = messageService.findAll(pageable);
        return ApiResultHandler.buildApiResult(200, "查询所有留言", all);
    }

    @GetMapping("/message/{id}")
    public ApiResult findById(@PathVariable("id") Integer id) {
        Optional<Message> res = messageService.findById(id);
        return ApiResultHandler.buildApiResult(200,"根据Id查询",res);
    }

    @DeleteMapping("/message/{id}")
    public int delete(@PathVariable("id") Integer id) {
        try {
            messageService.delete(id);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @PostMapping("/message")
    public ApiResult add(@RequestBody Message message) {
        Message res = messageService.add(message);
        if (res == null) {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        } else {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
    }
}
