package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.UserProfile;

import java.util.List;

/**
 * 商店用户标签及其权重的服务接口。
 */
public interface StoreUserProfileService {

    /**
     * 插入或更新用户标签及其权重，权重加1。
     *当用户浏览商品详情页时，权重+1
     * @param userId  用户ID
     * @param tagName 标签名
     */
    void insertOrUpdateStoreUserProfile(int userId, String tagName);

    /**
     * 插入或更新用户标签及其权重，权重加2。
     *当用户把商品加入购物车时，权重+2
     * @param userId  用户ID
     * @param tagName 标签名
     */
    void insertOrUpdateStoreUserProfileWithWeight2(int userId, String tagName);

    /**
     * 插入或更新用户标签及其权重，权重加3。
     *当用户购买商品时，权重+3
     * @param userId  用户ID
     * @param tagName 标签名
     */
    void insertOrUpdateStoreUserProfileWithWeight3(int userId, String tagName);

    /**
     * 根据用户ID获取所有用户标签及其权重。
     *
     * @param userId 用户ID
     * @return 用户标签及其权重列表
     */
    List<UserProfile> getStoreUserProfilesByUserId(int userId);
}
