package com.voss.taskgrinderbackend.Service;

import com.voss.taskgrinderbackend.pojo.Profile;

import java.util.List;

public interface ProfileService {
    void saveProfile(Profile profile);
    void updateProfile(Profile profile, String id);
    Profile getProfileById(String id);
    void deleteProfile(String id);

    List<Profile> getProfiles();
}
