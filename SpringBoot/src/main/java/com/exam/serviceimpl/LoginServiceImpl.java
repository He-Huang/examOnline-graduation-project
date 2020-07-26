package com.exam.serviceimpl;

import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;
import com.exam.dao.AdminDao;
import com.exam.dao.StudentDao;
import com.exam.dao.TeacherDao;
import com.exam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hehuang
 * @date 2020/4/4 - 16:41
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return adminDao.adminLogin(username,password);
    }

    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return teacherDao.teacherLogin(username,password);
    }

    @Override
    public Student studentLogin(Integer username, String password) {
        return studentDao.studentLogin(username,password);
    }
}
