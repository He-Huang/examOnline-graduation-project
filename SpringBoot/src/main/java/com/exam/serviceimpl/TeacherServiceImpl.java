package com.exam.serviceimpl;

import com.exam.entity.Teacher;
import com.exam.dao.TeacherDao;
import com.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/4/6 - 16:11
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Page<Teacher> findAll(Pageable page) {
        return teacherDao.findAll(page);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Optional<Teacher> findById(Integer teacherId) {
        return teacherDao.findById(teacherId);
    }

    @Override
    public void deleteById(Integer teacherId) {
        teacherDao.deleteById(teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public Teacher add(Teacher teacher) {
        return teacherDao.save(teacher);
    }
}
