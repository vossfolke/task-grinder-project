package com.voss.taskgrinderbackend.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getTasks(){
        return "tasks";
    }

    @GetMapping("/createTask")
    public String getCreateTask(){
        return "createTask";
    }
}
