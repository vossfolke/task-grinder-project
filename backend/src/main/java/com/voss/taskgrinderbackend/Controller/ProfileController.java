package com.voss.taskgrinderbackend.Controller;

import com.voss.taskgrinderbackend.Service.ProfileService;
import com.voss.taskgrinderbackend.pojo.Profile;
import com.voss.taskgrinderbackend.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable String id) {
        Profile profile = profileService.getProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/profile/all")
    public ResponseEntity<List<Profile>> getTasks(){
        List<Profile> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @PostMapping("/profile")
    public ResponseEntity<HttpStatus> createProfile(@RequestBody Profile profile) {
        profileService.saveProfile(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable String id, @RequestBody Profile profile){
        profileService.updateProfile(profile, id);
        return new ResponseEntity<>(profileService.getProfileById(id) ,HttpStatus.OK);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable String id){
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}