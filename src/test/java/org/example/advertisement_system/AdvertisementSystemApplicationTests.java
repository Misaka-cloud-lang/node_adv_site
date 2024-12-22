package org.example.advertisement_system;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class AdvertisementSystemApplicationTests {
    @Autowired
    private NewsUserProfileService newsUserProfileService;
    @Test
    void contextLoads() {
    }
    /**
     * 测试 UserProfileService 的功能。
     *
     * 该测试方法将执行以下操作：
     * 1. 插入或更新用户标签及其权重，权重加1。
     * 2. 插入或更新用户标签及其权重，权重加2。
     * 3. 插入或更新用户标签及其权重，权重加3。
     * 4. 获取用户ID为1的所有标签及其权重，并打印结果。
     */
    @Test
    void testUserProfileService() {
        // 插入或更新用户标签及其权重，权重加1
        newsUserProfileService.insertOrUpdateUserProfile(1, "tag1");
        newsUserProfileService.insertOrUpdateUserProfile(1, "tag1");

        newsUserProfileService.insertOrUpdateUserProfile(2, "tag1");

        // 插入或更新用户标签及其权重，权重加2
        newsUserProfileService.insertOrUpdateUserProfileWithWeight2(1, "tag2");
        newsUserProfileService.insertOrUpdateUserProfileWithWeight2(1, "tag2");

        // 插入或更新用户标签及其权重，权重加3
        newsUserProfileService.insertOrUpdateUserProfileWithWeight3(1, "tag3");
        newsUserProfileService.insertOrUpdateUserProfileWithWeight3(1, "tag3");

        // 获取用户ID为1的所有标签及其权重
        List<UserProfile> userProfiles = newsUserProfileService.getUserProfilesByUserId(1);
        for (UserProfile userProfile : userProfiles) {
            System.out.println(userProfile);
        }
    }
}
