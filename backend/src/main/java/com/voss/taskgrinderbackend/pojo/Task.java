package com.voss.taskgrinderbackend.pojo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;


@Entity
@Table(name = "questlog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quest_name", nullable = false)
    private String name;
    @Column(name = "date", nullable = false)
    @DateTimeFormat
    private Date date;
    @Column(name = "questType", nullable = false)
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "user_id", name = "user_id")
    private Profile profile;

}
