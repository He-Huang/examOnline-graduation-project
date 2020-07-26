package com.exam;

import com.exam.entity.Admin;
import com.exam.entity.ExamManage;
import com.exam.service.AdminService;
import com.exam.serviceimpl.ExamManageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamsystemApplicationTests {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ExamManageServiceImpl examManageService;

    @Test
    public void contextLoads() {
    }

    //查询所有方法
    @Test
    public void testFindAll() {
        Optional<ExamManage> exam = examManageService.findById(20190008);
        System.out.println(exam);
    }

}

