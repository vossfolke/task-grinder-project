package com.voss.taskgrinderbackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voss.taskgrinderbackend.Service.TaskService;
import com.voss.taskgrinderbackend.pojo.Task;

import java.util.List;


@RestController
public class TaskController {

    @Autowired private TaskService taskService;

    @GetMapping("/{userID}/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long userID){
        return new ResponseEntity<>(taskService.getTask(userID), HttpStatus.OK);
    }

    @GetMapping("/{userID}/task")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Long userID){
        return new ResponseEntity<>(taskService.getTasks(userID), HttpStatus.OK);
    }

    @PostMapping("/{userID}/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @PathVariable Long userID){
        return new ResponseEntity<>(taskService.saveTask(task, userID), HttpStatus.CREATED);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
