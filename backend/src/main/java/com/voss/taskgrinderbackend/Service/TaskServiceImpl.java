package com.voss.taskgrinderbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voss.taskgrinderbackend.repository.ProfileRepository;
import com.voss.taskgrinderbackend.repository.TaskRepository;
import com.voss.taskgrinderbackend.pojo.Profile;
import com.voss.taskgrinderbackend.pojo.Task;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired TaskRepository taskRepository;
    @Autowired ProfileRepository profileRepository;

    @Override
    public Task getTask(Long userID){
        return null;
    }

    @Override
    public List<Task> getTasks(Long userID){
        return (List<Task>) taskRepository.findByProfileUserId(userID);
    }

    @Override
    public Task saveTask(Task task, Long userID){
        Profile profile = profileRepository.findById(userID).get();
        task.setProfile(profile);
        return taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    
}
