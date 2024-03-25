package com.voss.taskgrinderbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.voss.taskgrinderbackend.pojo.Profile;

/**
 * ProfileRepository
 */

public interface ProfileRepository extends CrudRepository<Profile, Long>{
    
}
