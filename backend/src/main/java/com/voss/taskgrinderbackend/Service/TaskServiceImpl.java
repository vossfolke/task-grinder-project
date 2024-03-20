package com.voss.taskgrinderbackend.Service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.pojo.Task;

public class TaskServiceImpl implements TaskService {

    private int findIndexById(String id){
        return IntStream.range(0, TasksInMemory.getTasks().size())
        .filter(index -> TasksInMemory.getTasks().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow();
    }
    
}
