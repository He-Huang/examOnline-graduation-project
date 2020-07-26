package com.exam.vo;
/**
 * vo => View Object/Value Object 表现层对象/值对象
 */

import lombok.Data;

//题目答案类型
@Data
public class AnswerVO {
    private String question;
    private String subject;
    private Integer score;
    private String level;
    private Integer type;

    public AnswerVO(String question, String subject, Integer score, String level,Integer type) {
        this.question = question;
        this.subject = subject;
        this.score = score;
        this.level = level;
        this.type = type;
    }
}
