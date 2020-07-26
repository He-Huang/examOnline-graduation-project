package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

// 选择题实体
@Data
@Entity
@Table(name = "multi_question")
public class MultiQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;
    @Column
    private String subject;

    @Column(name = "answer_a")
    private String answerA;
    @Column(name = "answer_b")
    private String answerB;
    @Column(name = "answer_c")
    private String answerC;
    @Column(name = "answer_d")
    private String answerD;

    private String question;

    private String level;
    @Column(name = "right_answer")
    private String rightAnswer;

    private String analysis; //题目解析

    private Integer score;

    @Column(name = "question_type")
    private Integer questionType;

}