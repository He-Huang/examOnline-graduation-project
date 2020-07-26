package com.exam.controller;

import com.exam.entity.*;
import com.exam.serviceimpl.LoginServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hehuang
 * @date 2020/4/4 - 16:45
 */
@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login) {

        Integer username = login.getUsername();
        String password = login.getPassword();
        //admin登录结果
        Admin adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
        }
        //teacher登录结果
        Teacher teacherRes = loginService.teacherLogin(username,password);
        if (teacherRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", teacherRes);
        }
        //student登录结果
        Student studentRes = loginService.studentLogin(username,password);
        if (studentRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", studentRes);
        }

        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }
}
