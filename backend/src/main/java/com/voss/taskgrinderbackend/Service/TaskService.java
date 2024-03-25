package com.voss.taskgrinderbackend.Service;

import java.util.List;

import com.voss.taskgrinderbackend.pojo.Task;


public interface TaskService {

    Task getTaskById(Long id);
    void saveTask(Task task);
    void updateTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> getTasks();
}
