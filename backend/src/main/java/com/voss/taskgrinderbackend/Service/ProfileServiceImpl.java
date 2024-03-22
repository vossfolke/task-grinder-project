package com.voss.taskgrinderbackend.Service;

import com.voss.taskgrinderbackend.pojo.Profile;
import com.voss.taskgrinderbackend.repository.ProfilesInMemory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfilesInMemory profilesInMemory;
    @Override
    public void saveProfile(Profile profile) {
        profilesInMemory.addProfile(profile);
    }

    @Override
    public void updateProfile(Profile profile, String id) {
        profilesInMemory.updateProfile(findIndexById(id), profile);
    }

    @Override
    public Profile getProfileById(String id) {
        return profilesInMemory.getProfile(findIndexById(id));
    }

    @Override
    public void deleteProfile(String id) {
        profilesInMemory.deleteProfile(findIndexById(id));
    }

    private int findIndexById(String id){
        return IntStream.range(0, profilesInMemory.getProfiles().size())
                .filter(index -> profilesInMemory.getProfiles().get(index).getUserId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
