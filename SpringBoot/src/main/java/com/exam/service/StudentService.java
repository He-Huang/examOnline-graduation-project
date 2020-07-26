package com.exam.service;

import com.exam.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/6 - 14:40
 */
public interface StudentService {

    Page<Student> findAll(Pageable page);
//
    Optional<Student> findById(Integer studentId);
//
    void deleteById(Integer studentId);

    int update(Student student);

    int updatePwd(Student student);

    Student add(Student student);

    Student studentLogin( Integer username, String pwd);
}
