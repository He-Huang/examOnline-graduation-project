package com.exam.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "message_replays")
public class Replay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replay_id")
    private Integer replayId;
    @Column(name = "message_id")
    private Integer messageId;

    private String replay;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @Column(name = "replay_time")
    private Date replayTime;

//    @ManyToOne
//    @JoinColumn(name = "message_id", insertable = false, updatable = false)
//    private Message message;

}