package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.AdPlacementService;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.example.advertisement_system.service.StoreUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 广告投放控制器，处理广告投放请求。
 */
@RestController
@RequestMapping("/api/advertisement")
public class AdPlacementController {

    @Autowired
    private AdPlacementService adPlacementService;
    @Autowired
    private StoreUserProfileService storeUserProfileService;
    @Autowired
    private NewsUserProfileService newsUserProfileService;

    /**
     * 根据新闻网站用户标签和广告投放策略获取匹配的广告，交付渲染。
     *
     * @param userId 用户ID
     * @return 匹配的广告列表
     */
    @PostMapping("/place/news")
    public List<Advertisement> placeNewsAdvertisements(
            @RequestParam int userId
    ) {
        List<UserProfile> profiles = storeUserProfileService.getStoreUserProfilesByUserId(userId);
        List<Advertisement> newsAds = adPlacementService.getNewsAdPlacements(userId, profiles);
        return newsAds;
    }

    /**
     * 根据网店网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId 用户ID
     * @return 匹配的广告列表
     */
    @PostMapping("/place/store")
    public List<Advertisement> placeStoreAdvertisements(@RequestParam int userId) {
        List<UserProfile> profiles =
                newsUserProfileService.getUserProfilesByUserId(userId);
        return adPlacementService.getStoreAdPlacements(userId, profiles);
    }
}
