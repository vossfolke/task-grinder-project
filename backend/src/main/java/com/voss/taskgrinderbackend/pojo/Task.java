package com.voss.taskgrinderbackend.pojo;

import java.util.UUID;
import java.util.Date;



public class Task {

    private String name;
    //private Date date;
    private String value;
    private String id;


    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO add date getter & setter

    
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
