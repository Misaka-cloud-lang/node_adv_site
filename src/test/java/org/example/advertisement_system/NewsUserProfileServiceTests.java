package org.example.advertisement_system;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewsUserProfileServiceTests {

    @Autowired
    private NewsUserProfileService newsUserProfileService;

    /**
     * 测试 NewsUserProfileService 的功能。
     * <p>
     * 该测试方法将执行以下操作：
     * 1. 插入或更新用户标签及其权重，权重加1。
     * 2. 获取用户ID为1的所有标签及其权重，并验证结果。
     */
    @Test
    void testNewsUserProfileService() {
        // 插入或更新用户标签及其权重，权重加1

        newsUserProfileService.insertOrUpdateUserProfile(1, "entertainment");
        newsUserProfileService.insertOrUpdateUserProfile(1, "entertainment");
        newsUserProfileService.insertOrUpdateUserProfile(1, "finance");


        // 获取用户ID为1的所有标签及其权重
        List<UserProfile> userProfiles1 = newsUserProfileService.getUserProfilesByUserId(1);
        for (UserProfile userProfile : userProfiles1) {
            System.out.println(userProfile);
        }
    }
}
