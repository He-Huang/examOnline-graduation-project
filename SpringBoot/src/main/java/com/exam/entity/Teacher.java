package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "teacher_name")
    private String teacherName;

    private String institute;

    private String sex;

    private String tel;

    private String email;

    private String pwd;
    @Column(name = "card_id")
    private String cardId;

    private String type;

    private String role;
}