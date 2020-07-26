package com.exam.entity;

import lombok.Data;

import javax.persistence.*;

//填空题实体类
@Data
@Entity
@Table(name = "fill_question")
public class FillQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @Column
    private String subject;

    private String question;

    private String answer;

    private Integer score;

    private String level;

    private String analysis; //题目解析
    @Column(name = "question_type")
    private Integer questionType;
}
