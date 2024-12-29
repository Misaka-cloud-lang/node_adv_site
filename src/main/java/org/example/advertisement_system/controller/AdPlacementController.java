package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.AdPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 广告投放控制器，处理广告投放请求。
 */
@RestController
@RequestMapping("/api/advertisement")
public class AdPlacementController {

    @Autowired
    private AdPlacementService adPlacementService;

    /**
     * 根据新闻网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId           用户ID
     * @param newsUserProfiles 新闻用户标签及其权重列表
     * @return 匹配的广告列表
     */
    @PostMapping("/place/news")
    public List<Advertisement> placeNewsAdvertisements(@RequestParam int userId, @RequestBody List<UserProfile> newsUserProfiles) {
        List<Advertisement> newsAds= adPlacementService.getNewsAdPlacements(userId, newsUserProfiles);
        return newsAds;
    }

    /**
     * 根据网店网站用户标签和广告投放策略获取匹配的广告。<br/>
     * 参见{@link #placeNewsAdvertisements(int, List)}
     */
    @PostMapping("/place/store")
    public List<Advertisement> placeStoreAdvertisements(@RequestParam int userId, @RequestBody List<UserProfile> storeUserProfiles) {
        return adPlacementService.getStoreAdPlacements(userId, storeUserProfiles);
    }
}
