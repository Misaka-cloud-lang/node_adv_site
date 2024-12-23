package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.UserProfile;

import java.util.List;

public interface NewsUserProfileService {

    /**
     * 插入或更新用户标签及其权重，权重加1。
     *当用户浏览新闻时，权重+1
     * @param userId  用户ID
     * @param tagName 标签名
     */
    void insertOrUpdateUserProfile(int userId, String tagName);

    /**
     * 根据用户ID获取所有用户标签及其权重。
     *
     * @param userId 用户ID
     * @return 用户标签及其权重列表
     */
    List<UserProfile> getUserProfilesByUserId(int userId);
}
