package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    /**
     * 在JPA源码中，应该是在碰到驼峰标识的时候，将转成了下划线”_”+小写的形式，
     * 所以 adminName 会转成 admin_name去查询。所以查出来的字段数据为null
     */
    @Column(name = "admin_name")
    private String adminName;
    @Column
    private String sex;
    @Column
    private String tel;
    @Column
    private String email;
    @Column
    private String pwd;
    @Column(name = "card_id")
    private String cardId;
    private String role;
}