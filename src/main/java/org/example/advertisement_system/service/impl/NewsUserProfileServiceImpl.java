package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.mapper.NewsUserProfileMapper;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsUserProfileServiceImpl implements NewsUserProfileService {

    @Autowired
    private NewsUserProfileMapper newsUserProfileMapper;

    @Override
    public void insertOrUpdateUserProfile(int userId, String tagName) {
        UserProfile userProfile = new UserProfile(userId, tagName, 1);
        newsUserProfileMapper.insertOrUpdateUserProfile(userProfile);
    }

    @Override
    public void insertOrUpdateUserProfileWithWeight2(int userId, String tagName) {
        UserProfile userProfile = new UserProfile(userId, tagName, 2);
        newsUserProfileMapper.insertOrUpdateUserProfileWithWeight2(userProfile);
    }

    @Override
    public void insertOrUpdateUserProfileWithWeight3(int userId, String tagName) {
        UserProfile userProfile = new UserProfile(userId, tagName, 3);
        newsUserProfileMapper.insertOrUpdateUserProfileWithWeight3(userProfile);
    }

    @Override
    public List<UserProfile> getUserProfilesByUserId(int userId) {
        return newsUserProfileMapper.getUserProfilesByUserId(userId);
    }
}
