package com.voss.taskgrinderbackend.Controller;

import com.voss.taskgrinderbackend.Service.ProfileService;
import com.voss.taskgrinderbackend.pojo.Profile;
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
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK);
    }

    @GetMapping("/profile/all")
    public ResponseEntity<List<Profile>> getTasks(){
        return new ResponseEntity<>(profileService.getProfiles(), HttpStatus.OK);
    }

    @PostMapping("/profile")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        profileService.saveProfile(profile);
        return new ResponseEntity<>(profileService.saveProfile(profile), HttpStatus.CREATED);

    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile){
        return new ResponseEntity<>(profileService.saveProfile(profile) ,HttpStatus.OK);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}