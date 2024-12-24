package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;

import java.util.List;

/**
 * 广告投放服务接口，定义了根据用户标签和广告投放策略获取匹配广告的操作。
 */
public interface AdPlacementService {
    /**
     * 根据新闻网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId           用户ID
     * @param newsUserProfiles 新闻用户标签及其权重列表
     * @return 匹配的广告列表
     */
    List<Advertisement> getNewsAdPlacements(int userId, List<UserProfile> newsUserProfiles);

    /**
     * 根据网店网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId            用户ID
     * @param storeUserProfiles 商店用户标签及其权重列表
     * @return 匹配的广告列表
     */
    List<Advertisement> getStoreAdPlacements(int userId, List<UserProfile> storeUserProfiles);
}
