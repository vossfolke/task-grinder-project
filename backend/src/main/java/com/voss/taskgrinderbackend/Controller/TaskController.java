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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TaskController {

    @Autowired private TaskService taskService;

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/task/all")
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<HttpStatus> createTask(@RequestBody Task task){
        taskService.saveTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        taskService.updateTask(id, task);
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
