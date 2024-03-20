package com.voss.taskgrinderbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.pojo.Task;


public interface TaskService {

    Task getTaskById(String id);
    //void saveTask(Task task);
    //void updateTask(String id, Task task);
    //void deleteTask(String id);
    List<Task> getTasks();
}
