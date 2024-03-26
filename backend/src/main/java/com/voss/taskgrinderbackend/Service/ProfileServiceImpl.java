package com.voss.taskgrinderbackend.Service;

import com.voss.taskgrinderbackend.pojo.Profile;
import com.voss.taskgrinderbackend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileByUserId(Long id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);;
    }

    @Override
    public List<Profile> getProfiles() {
        return (List<Profile>) profileRepository.findAll();
    }

}
