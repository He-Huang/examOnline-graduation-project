package com.exam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exam_manage")
public class ExamManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_code")
    private Integer examCode;
    @Column
    private String description;

    private String source;
    @Column(name = "paper_id")
    private Integer paperId;
    @Column(name = "exam_date")
    private String examDate;
    @Column(name = "total_time")
    private Integer totalTime;

    private String grade;

    private String term;

    private String major;

    private String institute;
    @Column(name = "total_score")
    private Integer totalScore;

    private String type;

    private String tips;
}