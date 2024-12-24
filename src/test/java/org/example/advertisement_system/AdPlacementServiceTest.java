package org.example.advertisement_system;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.AdPlacementService;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试类，用于测试 {@link AdPlacementService} 的功能。
 * 该测试类包含以下测试方法：
 * - {@link #testGetNewsAdPlacements()}：测试获取新闻广告推荐功能。
 * - {@link #testGetStoreAdPlacements()}：测试获取网店广告推荐功能。
 *
 * @author 您的姓名
 * @version 1.0
 */
@SpringBootTest
class AdPlacementServiceTest {

    @Autowired
    private AdPlacementService adPlacementService;

    @Autowired
    private NewsUserProfileService newsUserProfileService;

    /**
     * 测试获取新闻广告推荐功能。
     * 该测试方法将执行以下操作：
     * 1. 获取用户ID为1的所有标签及其权重。
     * 2. 调用 {@link AdPlacementService#getNewsAdPlacements(int, List)} 方法获取推荐广告。
     * 3. 输出推荐广告到控制台。
     */
    @Test
    public void testGetNewsAdPlacements() {
        // 获取用户ID为1的所有标签及其权重
        List<UserProfile> newsUserProfiles1 = newsUserProfileService.getUserProfilesByUserId(1);
        //输出用户ID为1的所有标签及其权重
        newsUserProfiles1.forEach(userProfile -> System.out.println("用户ID为1的标签及其权重: " + userProfile.getTagName() + ":" + userProfile.getTagWeight()));
        // 获取推荐广告
        List<Advertisement> recommendedAds1 = adPlacementService.getNewsAdPlacements(1, newsUserProfiles1);//打印用户ID为1的广告匹配得分

        // 输出推荐广告到控制台
        recommendedAds1.forEach(ad -> System.out.println("1的推荐广告: " + ad));
        System.out.println("---------------------");
        // 获取用户ID为2的所有标签及其权重
        List<UserProfile> newsUserProfiles2 = newsUserProfileService.getUserProfilesByUserId(2);

        // 获取推荐广告
        List<Advertisement> recommendedAds2 = adPlacementService.getNewsAdPlacements(2, newsUserProfiles2);

        // 输出推荐广告到控制台
        recommendedAds2.forEach(ad -> System.out.println("2的推荐广告: " + ad));
    }

    /**
     * 测试获取网店广告推荐功能。
     * 该测试方法将执行以下操作：
     * 1. 获取用户ID为2的所有标签及其权重。
     * 2. 调用 {@link AdPlacementService#getStoreAdPlacements(int, List)} 方法获取推荐广告。
     * 3. 输出推荐广告到控制台。
     */
    @Test
    public void testGetStoreAdPlacements() {
        List<UserProfile> storeUserProfiles = newsUserProfileService.getUserProfilesByUserId(2);

        // 获取推荐广告
        List<Advertisement> recommendedAds = adPlacementService.getStoreAdPlacements(2, storeUserProfiles);

        // 输出推荐广告到控制台
        recommendedAds.forEach(ad -> System.out.println("推荐广告: " + ad.getTitle()));
    }
}
