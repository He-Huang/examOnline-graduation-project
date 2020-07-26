package com.exam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "exam_code")
    private Integer examCode;

    @Column(name = "student_id")
    private Integer studentId;

    private String subject;
    @Column(name = "pt_score")
    private Integer ptScore;
    @Column(name = "et_score")
    private Integer etScore;
    private Integer score;

    @Column(name = "answer_date")
    private String answerDate;
}