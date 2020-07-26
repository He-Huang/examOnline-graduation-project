package com.exam.service;

import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;

import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/4 - 16:40
 */
public interface LoginService {
    Admin adminLogin(Integer username, String password);

    Teacher teacherLogin(Integer username, String password);

    Student studentLogin(Integer username, String password);
}
