package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;

    private String grade;

    private String major;

    private String clazz;

    private String institute;

    private String tel;

    private String email;

    private String pwd;
    @Column(name = "card_id")
    private String cardId;

    private String sex;

    private String role;

}