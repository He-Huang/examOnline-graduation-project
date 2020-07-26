package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.ExamManage;
import com.exam.entity.FillQuestion;
import com.exam.serviceimpl.FillQuestionServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hehuang
 * @date 2020/4/5 - 21:42
 */
@RestController
public class FillQuestionController {
    @Autowired
    private FillQuestionServiceImpl fillQuestionService;

    @PostMapping("/fillQuestion")
    public ApiResult add(@RequestBody FillQuestion fillQuestion) {
        FillQuestion res = fillQuestionService.add(fillQuestion);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/fillQuestionId")
    public ApiResult findLastQuestionId() {
        Integer res = fillQuestionService.findLastQuestionId();
        return ApiResultHandler.buildApiResult(200, "查询成功", res);
    }

    @GetMapping("/fillQuestion/{page}/{size}")
    public ApiResult findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageable = PageRequest.of(page,size);
        Page<AnswerVO> all = fillQuestionService.findAllFill(pageable);
        return ApiResultHandler.buildApiResult(200, "查询成功", all);
    }
}
