package com.voss.taskgrinderbackend.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.Constants;
import com.voss.taskgrinderbackend.Service.Task;

@Controller
public class TaskController {

    TasksInMemory tasks = new TasksInMemory();

    @GetMapping("/tasks")
    public String getTasks(Model model){

        model.addAttribute("tasks", tasks.getTasks());
        return "tasks";
    }

    @GetMapping("/createTask")
    public String getCreateTask(Model model, @RequestParam(required = false) String id){
        Task task;
        int index = getTaskIndex(id);
        model.addAttribute("task", index == Constants.NOT_FOUND ? new Task() : tasks.getTask(index));
        return "createTask";
    }

    public Integer getTaskIndex(String id){
        for(int i = 0; i < tasks.getTasks().size(); i++) {
            if(tasks.getTask(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    @PostMapping("/handleSubmit")
    public String submitTask(Task task) {
        int index = getTaskIndex(task.getId());
        if (index == Constants.NOT_FOUND){
            tasks.addTask(task);
        } else {
            tasks.updateTask(index, task);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String deleteTask(String id) {
        for(int i=0; i < tasks.getTasks().size(); i++) {
            if(tasks.getTask(i).getId().equals(id)){
                tasks.deleteTask(i);
            }
        }
        return "redirect:/tasks";
    }


}
