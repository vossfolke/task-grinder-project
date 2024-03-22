package com.voss.taskgrinderbackend.pojo;

import java.util.UUID;

public class Profile {
    private String username;
    private String userId;

    public Profile() {
        this.userId = UUID.randomUUID().toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
