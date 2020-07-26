package com.exam.dao;

import com.exam.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:13
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
    //分页查询所有学生
    Page<Student> findAll(Pageable page);

    Optional<Student> findById(Integer id);

    //更新学生信息
    @Modifying
    @Transactional
    @Query(value = "update Student set student_name = :#{#student.studentName},grade = :#{#student.grade},major = :#{#student.major},clazz = :#{#student.clazz}, institute = :#{#student.institute},tel = :#{#student.tel},email = :#{#student.email},pwd = :#{#student.pwd},card_id = :#{#student.cardId},sex = :#{#student.sex},role = :#{#student.role} where student_id = :#{#student.studentId}")
    int update(@Param("student") Student student);

    //修改密码
    @Modifying
    @Transactional
    @Query(value = "update Student set pwd = :#{#student.pwd} where student_id= :#{#student.studentId}")
    int updatePwd(@Param("student") Student student);


    //学生登录方法
    @Query(value = "select * from student where student_id=? and pwd = ?",nativeQuery = true)
    Student studentLogin( Integer username, String pwd);
}
