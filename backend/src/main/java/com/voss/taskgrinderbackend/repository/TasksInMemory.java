package com.voss.taskgrinderbackend.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.voss.taskgrinderbackend.pojo.Task;

@Repository
public class TasksInMemory{

    private List<Task> tasks = Arrays.asList(
        new Task("name", "low", "1")
    );

    public Task getTask(int index){
                return tasks.get(index);
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }

    public void updateTask(int index, Task task){
        tasks.set(index, task);
    }

    public void deleteTask(int index){
        tasks.remove(index);
    }

    public List<Task> getTasks(){
        return tasks;
    }


}