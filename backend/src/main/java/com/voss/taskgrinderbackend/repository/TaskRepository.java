package com.voss.taskgrinderbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.voss.taskgrinderbackend.pojo.Task;



/**
 * TaskRepository
 */

public interface TaskRepository extends CrudRepository<Task, Long>{
    List<Task> findByProfileUserId(Long userId);
}
