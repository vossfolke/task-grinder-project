package com.voss.taskgrinderbackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voss.taskgrinderbackend.Service.TaskService;
import com.voss.taskgrinderbackend.pojo.Task;

import java.util.List;


@RestController
public class TaskController {

    @Autowired private TaskService taskService;

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @GetMapping("/task/all")
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
