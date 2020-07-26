package com.exam.dao;
import	java.util.Optional;

import com.exam.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer> {
    //部分也查询所有
    List<Teacher> findAll();
    //分页查询所有
    Page<Teacher> findAll(Pageable page);

    Optional<Teacher> findById(Integer teacherId);

    void deleteById(Integer teacherId);

    @Modifying
    @Transactional
    @Query(value = "update Teacher set teacher_name = :#{#teacher.teacherName}, institute = :#{#teacher.institute},tel = :#{#teacher.tel},email = :#{#teacher.email},pwd = :#{#teacher.pwd},card_id = :#{#teacher.cardId},sex = :#{#teacher.sex},role = :#{#teacher.role},type = :#{#teacher.type} where teacher_id = :#{#teacher.teacherId}")
    int update(@Param("teacher") Teacher teacher);

    //教师的登录方法
    @Query(value = "select * from Teacher where teacher_id=? and pwd = ?",nativeQuery = true)
    Teacher teacherLogin(Integer username, String pwd);
}
