package com.exam.service;

import com.exam.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/6 - 16:11
 */
public interface TeacherService {

    Page<Teacher> findAll(Pageable page);

    public List<Teacher> findAll();

    public Optional<Teacher> findById(Integer teacherId);

    public void deleteById(Integer teacherId);

    public int update(Teacher teacher);

    public Teacher add(Teacher teacher);
}
