package com.simpleboard.board.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date date;

}
