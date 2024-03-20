package com.voss.taskgrinderbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.Constants;
import com.voss.taskgrinderbackend.Task;

@Service
public class TaskService {

    @Autowired TasksInMemory tasks;

    public List<Task> getTasks (){
        return tasks.getTasks();
    }
    
    public Task getTaskById (String id){
        int index = getTaskIndex(id);
        return index == Constants.NOT_FOUND ? new Task() : tasks.getTask(index);
    }

    public Integer getTaskIndex(String id){
        for(int i = 0; i < tasks.getTasks().size(); i++) {
            if(tasks.getTask(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public void submitTask(Task task){
        int index = getTaskIndex(task.getId());
        if (index == Constants.NOT_FOUND){
            tasks.addTask(task);
        } else {
            tasks.updateTask(index, task);
        }
    }

    public void deleteTask(String id){
        for(int i=0; i < tasks.getTasks().size(); i++) {
            if(tasks.getTask(i).getId().equals(id)){
                tasks.deleteTask(i);
            }
        }
    }




}
