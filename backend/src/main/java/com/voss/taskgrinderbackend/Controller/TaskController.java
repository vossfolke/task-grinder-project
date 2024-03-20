package com.voss.taskgrinderbackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voss.taskgrinderbackend.Task;
import com.voss.taskgrinderbackend.Service.TaskService;

import jakarta.validation.Valid;


@Controller
public class TaskController {

    @Autowired TaskService taskService;

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/createTask")
    public String getCreateTask(Model model, @RequestParam(required = false) String id){
        model.addAttribute("task", taskService.getTaskById(id));
        return "createTask";
    }


    @PostMapping("/handleSubmit")
    public String submitTask(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "createTask";
        }
        taskService.submitTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String deleteTask(String id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }


}
