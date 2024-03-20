package com.voss.taskgrinderbackend.pojo;

import java.util.UUID;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Task {

    private String name;
    //private Date date;
    private String value;
    private String id;

    public Task (String name, String value, String id){
        this.name = name;
        this.value = value;
        this.id = id;
    }

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public Date getDate() {
        //return date;
    //}

    //public void setDate(Date date) {
     //   this.date = date;
    //}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
