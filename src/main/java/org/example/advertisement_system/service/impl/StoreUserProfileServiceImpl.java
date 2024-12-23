package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.mapper.StoreUserProfileMapper;
import org.example.advertisement_system.service.StoreUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商店用户标签及其权重的服务实现类。
 */
@Service
public class StoreUserProfileServiceImpl implements StoreUserProfileService {

    @Autowired
    private StoreUserProfileMapper storeUserProfileMapper;

    @Override
    public void insertOrUpdateStoreUserProfile(int userId, String tagName) {
        UserProfile storeUserProfile = new UserProfile(userId, tagName, 1);
        storeUserProfileMapper.insertOrUpdateStoreUserProfile(storeUserProfile);
    }

    @Override
    public void insertOrUpdateStoreUserProfileWithWeight2(int userId, String tagName) {
       UserProfile storeUserProfile = new UserProfile(userId, tagName, 2);
        storeUserProfileMapper.insertOrUpdateStoreUserProfileWithWeight2(storeUserProfile);
    }

    @Override
    public void insertOrUpdateStoreUserProfileWithWeight3(int userId, String tagName) {
        UserProfile storeUserProfile = new UserProfile(userId, tagName, 3);
        storeUserProfileMapper.insertOrUpdateStoreUserProfileWithWeight3(storeUserProfile);
    }

    @Override
    public List<UserProfile> getStoreUserProfilesByUserId(int userId) {
        return storeUserProfileMapper.getStoreUserProfilesByUserId(userId);
    }
}
