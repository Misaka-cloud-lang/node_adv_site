package org.example.advertisement_system;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.StoreUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreUserProfileServiceTests {

    @Autowired
    private StoreUserProfileService storeUserProfileService;

    /**
     * 测试 StoreUserProfileService 的功能。
     *
     * 该测试方法将执行以下操作：
     * 1. 插入或更新用户标签及其权重，权重加1。
     * 2. 插入或更新用户标签及其权重，权重加2。
     * 3. 插入或更新用户标签及其权重，权重加3。
     * 4. 获取用户ID为1的所有标签及其权重，并验证结果。
     */
    @Test
    void testStoreUserProfileService() {
        // 插入或更新用户标签及其权重，权重加1
        storeUserProfileService.insertOrUpdateStoreUserProfile(1, "books");
        storeUserProfileService.insertOrUpdateStoreUserProfile(1, "books");

        storeUserProfileService.insertOrUpdateStoreUserProfile(2, "books");

        // 插入或更新用户标签及其权重，权重加2
        storeUserProfileService.insertOrUpdateStoreUserProfileWithWeight2(1, "books");
        storeUserProfileService.insertOrUpdateStoreUserProfileWithWeight2(1, "books");

        // 插入或更新用户标签及其权重，权重加3
        storeUserProfileService.insertOrUpdateStoreUserProfileWithWeight3(2, "sportsEquipment");
        storeUserProfileService.insertOrUpdateStoreUserProfileWithWeight3(2, "sportsEquipment");

        // 获取用户ID为1的所有标签及其权重
        List<UserProfile> storeUserProfiles = storeUserProfileService.getStoreUserProfilesByUserId(1);

        for (UserProfile userProfile : storeUserProfiles) {
            System.out.println(userProfile);
        }
    }
}
