package com.voss.taskgrinderbackend.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voss.taskgrinderbackend.repository.TasksInMemory;
import com.voss.taskgrinderbackend.Constants;

@Controller
public class TaskController {

    TasksInMemory tasks = new TasksInMemory();

    @GetMapping("/tasks")
    public String getTasks(Model model){

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/createTask")
    public String getCreateTask(Model model, @RequestParam(required = false) String id){
        Task task;
        int index = getTaskIndex(id);
        model.addAttribute("task", index == Constants.NOT_FOUND ? new Task() : tasks.get(index));
        return "createTask";
    }

    public Integer getTaskIndex(String id){
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    @PostMapping("/handleSubmit")
    public String submitTask(Task task) {
        int index = getTaskIndex(task.getId());
        if (index == Constants.NOT_FOUND){
            tasks.add(task);
        } else {
            tasks.set(index, task);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String deleteTask(String id) {
        for(int i=0; i < tasks.size(); i++) {
            if(tasks.get(i).getId().equals(id)){
                tasks.remove(i);
            }
        }
        return "redirect:/tasks";
    }


}
