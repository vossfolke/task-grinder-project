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
    private Date date;
    @Column(name = "questType", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userID", name = "profile_id")
    private Profile profile;

}
