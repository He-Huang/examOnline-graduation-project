package com.exam.controller;
import	java.util.concurrent.locks.ReentrantLock;

import com.exam.entity.ApiResult;
import com.exam.entity.Student;
import com.exam.serviceimpl.StudentServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/6 - 14:50
 */
@RestController
public class StudentContoller {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/students/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        System.out.println("分页查询所有学生");
        PageRequest pageable = PageRequest.of(page,size);
        Page<Student> studentsByPage = studentService.findAll(pageable);
        ApiResult apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", studentsByPage);
        return apiResult;
    }

    @GetMapping("/student/{id}")
    public ApiResult findById(@PathVariable("id") Integer id){
        Optional<Student> s = studentService.findById(id);
        System.out.println(s);
        ApiResult result = ApiResultHandler.buildApiResult(200, "请求成功!", s);
        return result;
    }

    @DeleteMapping("/student/{id}")
    public ApiResult deleteById(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
        return ApiResultHandler.success();
    }

    @PostMapping("/student/add")
    public ApiResult add(@RequestBody Student student){
        Student s = studentService.add(student);
        ApiResult result = null;
        if(s != null){
            result = ApiResultHandler.buildApiResult(200, "添加学生成功!", s);
        }
        return result;
    }

    @PutMapping("/studentPWD")
    public ApiResult updatePwd(@RequestBody Student student) {
        studentService.updatePwd(student);
        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
    }

    @PutMapping("/student")
    public ApiResult update(@RequestBody Student student) {
        int res = studentService.update(student);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
}
