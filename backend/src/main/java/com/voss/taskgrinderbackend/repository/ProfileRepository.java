package com.voss.taskgrinderbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.voss.taskgrinderbackend.pojo.Profile;
import java.util.List;


/**
 * ProfileRepository
 */

public interface ProfileRepository extends CrudRepository<Profile, Long>{
    Profile findByUserId(Long userId);
}
