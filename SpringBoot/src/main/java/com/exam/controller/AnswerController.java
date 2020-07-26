package com.exam.controller;
import java.util.*;

import com.exam.serviceimpl.FillQuestionServiceImpl;
import com.exam.serviceimpl.JudgeQuestionServiceImpl;
import com.exam.serviceimpl.MultiQuestionServiceImpl;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnswerController {
    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;
    @Autowired
    private FillQuestionServiceImpl fillQuestionService;
    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;

    @GetMapping("/answers/{page}/{size}")
    public Map<Integer, Page<?>> findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageable;
        PageRequest pageable2;
        if (size % 3 == 0) {
            size = size / 3;
            pageable =  PageRequest.of(page, size);
            pageable2 = PageRequest.of(page,size);
        } else if (size % 3 == 1) {
            size = (size - 1) / 3;
            pageable = PageRequest.of(page,size);
            pageable2 = PageRequest.of(page,size+1);
        } else {
            size = (size + 1) / 3;
            pageable = PageRequest.of(page,size);
            pageable2 = PageRequest.of(page,size-1);
        }

        Page<AnswerVO> multiQuestions = multiQuestionService.findAllMulti(pageable);   //选择题题库 1
        Page<AnswerVO> fillQuestions = fillQuestionService.findAllFill(pageable);      //填空题题库 2
        Page<AnswerVO> judgeQuestions = judgeQuestionService.findAllJudge(pageable2);   //判断题题库 3
        Map<Integer, Page<?>> all = new HashMap<>();
        all.put(1, multiQuestions);
        all.put(2, fillQuestions);
        all.put(3, judgeQuestions);
        return all;
    }
}
