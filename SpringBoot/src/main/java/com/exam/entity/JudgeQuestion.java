package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

//判断题实体类
@Data
@Entity
@Table(name = "judge_question")
public class JudgeQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;
    @Column
    private String subject;

    private String question;

    private String answer;

    private String level;

    private Integer score;

    private String analysis; //题目解析

    @Column(name = "question_type")
    private Integer questionType;

}