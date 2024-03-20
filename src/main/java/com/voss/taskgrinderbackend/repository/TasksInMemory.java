package com.voss.taskgrinderbackend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.voss.taskgrinderbackend.Task;

@Repository
public class TasksInMemory{

    private List<Task> tasks = new ArrayList<>();

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