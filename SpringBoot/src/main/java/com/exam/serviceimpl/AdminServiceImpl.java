package com.exam.serviceimpl;

import com.exam.entity.Admin;
import com.exam.dao.AdminDao;
import com.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service   // 如果一个类带了@Service注解，将自动注册到Spring容器
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Optional<Admin> findById(Integer adminId) {
        return adminDao.findById(adminId);
    }

    @Override
    public void deleteById(int adminId) {
        adminDao.deleteById(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Admin add(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Page<Admin> findAll(Pageable page) {
        return adminDao.findAll(page);
    }

    @Override
    public Admin adminLogin(Integer username, String pwd) {
        return adminDao.adminLogin(username,pwd);
    }
}
