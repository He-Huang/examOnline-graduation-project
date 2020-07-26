package com.exam.service;

import com.exam.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author hehuang
 * @date 2020/3/22 - 14:00
 */

public interface AdminService {
    //查询所有管理员
    List<Admin> findAll();

    Optional<Admin> findById(Integer adminId);

    void deleteById(int adminId);

    Admin update(Admin admin);

    Admin add(Admin admin);

    //分页获取管理员
    Page<Admin> findAll(Pageable page);

    Admin adminLogin(Integer username,String pwd);
}
