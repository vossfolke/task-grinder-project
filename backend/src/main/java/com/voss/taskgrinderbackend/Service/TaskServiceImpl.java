package com.voss.taskgrinderbackend.Service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.TaskRepository;
import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.pojo.Task;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired private TaskRepository taskRepository;

    @Override
    public Task getTask(Long id){
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasks(){
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    
}
