package com.voss.taskgrinderbackend.Service;

import java.util.List;

import com.voss.taskgrinderbackend.pojo.Task;


public interface TaskService {

    Task getTask(Long userId);
    Task saveTask(Task task, Long userID);
    void deleteTask(Long id);
    List<Task> getTasks(Long userID);
}
