package com.voss.taskgrinderbackend.Service;

import com.voss.taskgrinderbackend.pojo.Profile;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile);
    Profile getProfileByUserId(Long id);
    void deleteProfile(Long id);
    List<Profile> getProfiles();
}
