package com.exam.dao;

import com.exam.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author hehuang
 * @date 2020/3/22 - 15:12
 */
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
    //分页获取管理员
    /*
    要实现分页获取所有实体，方法名必须是findAll 否则会报错。
    因为继承自JpaRepository 继承 PagingAndSortingRepository 实现的方法名就是findAll不可修改
    */
    Page<Admin> findAll(Pageable page);

    @Query(value = "select * from Admin where admin_id= ? and pwd = ?",nativeQuery = true)
    Admin adminLogin( Integer username, String pwd);
}
