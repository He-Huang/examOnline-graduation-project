package com.exam.serviceimpl;

import com.exam.entity.Student;
import com.exam.dao.StudentDao;
import com.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/6 - 14:47
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student studentLogin(Integer username, String pwd) {
        return studentDao.studentLogin(username,pwd);
    }

    @Override
    public Page<Student> findAll(Pageable page) {
        return studentDao.findAll(page);
    }

    @Override
    public Optional<Student> findById(Integer studentId) {
        return studentDao.findById(studentId);
    }
//
    @Override
    public void deleteById(Integer studentId) {
        studentDao.deleteById(studentId);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int updatePwd(Student student) {
        return studentDao.updatePwd(student);
    }

    @Override
    public Student add(Student student) {
        return studentDao.save(student);
    }
}
