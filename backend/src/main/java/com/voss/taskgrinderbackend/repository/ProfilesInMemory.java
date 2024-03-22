package com.voss.taskgrinderbackend.repository;

import com.voss.taskgrinderbackend.pojo.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfilesInMemory {
    private List<Profile> profiles = new ArrayList<>();

    public void addProfile(Profile profile){
        profiles.add(profile);
    }

    public void deleteProfile(int index){
        profiles.remove(index);
    }

    public void updateProfile(int index, Profile profile){
        profiles.set(index, profile);
    }

   public Profile getProfile(int index){
        return profiles.get(index);
   }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
