package com.voss.taskgrinderbackend.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/")
    public String getTasks(){
        return "tasks";
    }
}
