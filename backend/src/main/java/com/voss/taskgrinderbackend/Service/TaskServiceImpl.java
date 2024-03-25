package com.voss.taskgrinderbackend.Service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.pojo.Task;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired private TasksInMemory tasksInMemory;

    @Override
    public Task getTaskById(Long id){
        return tasksInMemory.getTask(findIndexById(id));
    }

    private int findIndexById(Long id){
        return IntStream.range(0, tasksInMemory.getTasks().size())
        .filter(index -> tasksInMemory.getTasks().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

    @Override
    public List<Task> getTasks(){
        return tasksInMemory.getTasks();
    }

    @Override
    public void saveTask(Task task){
        tasksInMemory.addTask(task);
    }

    @Override
    public void updateTask(Long id, Task task){
        tasksInMemory.updateTask(findIndexById(id), task);
    }

    @Override
    public void deleteTask(Long id){
        tasksInMemory.deleteTask(findIndexById(id));
    }
    
}
