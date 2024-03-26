package com.voss.taskgrinderbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.voss.taskgrinderbackend.pojo.Profile;
import com.voss.taskgrinderbackend.repository.ProfileRepository;

@SpringBootApplication
public class TaskGrinderBackendApplication implements CommandLineRunner {

	@Autowired
	ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskGrinderBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile[] profiles = new Profile[]{
			new Profile("test1", 1L),
			new Profile("test2", 2L)
		};
		for (int i=0; i< profiles.length; i++){
			profileRepository.save(profiles[i]);
		}
	}


}
