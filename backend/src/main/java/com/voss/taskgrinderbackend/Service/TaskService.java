package com.voss.taskgrinderbackend.Service;

import java.util.List;

import com.voss.taskgrinderbackend.pojo.Task;


public interface TaskService {

    Task getTaskById(String id);
    void saveTask(Task task);
    //void updateTask(String id, Task task);
    //void deleteTask(String id);
    List<Task> getTasks();
}
