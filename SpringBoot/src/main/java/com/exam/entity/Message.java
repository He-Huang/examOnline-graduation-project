package com.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //private Integer temp_id;//解决id为null创建的一个临时id
    @Column
    private String title;

    private String content;

    @Column(name = "message_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date time;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "message_id")
    List<Replay> replays;   //一对多关系，评论信息
}