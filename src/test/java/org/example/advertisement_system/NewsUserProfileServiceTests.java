package org.example.advertisement_system;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.example.advertisement_system.service.StoreUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsUserProfileServiceTests {

    @Autowired
    private NewsUserProfileService newsUserProfileService;

    /**
     * 测试 NewsUserProfileService 的功能。
     *
     * 该测试方法将执行以下操作：
     * 1. 插入或更新用户标签及其权重，权重加1。
     * 2. 获取用户ID为1的所有标签及其权重，并验证结果。
     */
    @Test
    void testNewsUserProfileService() {
        // 插入或更新用户标签及其权重，权重加1
        newsUserProfileService.insertOrUpdateUserProfile(1, "tag1");
        newsUserProfileService.insertOrUpdateUserProfile(1, "tag1");

        newsUserProfileService.insertOrUpdateUserProfile(2, "tag1");


        // 获取用户ID为1的所有标签及其权重
        List<UserProfile> userProfiles = newsUserProfileService.getUserProfilesByUserId(2);
        for (UserProfile userProfile : userProfiles) {
            System.out.println(userProfile);
        }
    }
}
