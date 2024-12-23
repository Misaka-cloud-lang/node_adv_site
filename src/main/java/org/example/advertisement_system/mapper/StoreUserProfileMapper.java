package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.*;
import org.example.advertisement_system.entity.UserProfile;

import java.util.List;

/**
 * 商店用户标签及其权重的 MyBatis Mapper 接口。
 */
@Mapper
public interface StoreUserProfileMapper {

    /**
     * 插入或更新用户标签及其权重。
     * 如果标签已存在，则权重加1；否则插入新标签并设置权重为1。
     *
     * @param storeUserProfile 用户标签及其权重
     */
    void insertOrUpdateStoreUserProfile(UserProfile storeUserProfile);

    /**
     * 插入或更新用户标签及其权重。
     * 如果标签已存在，则权重加2；否则插入新标签并设置权重为2。
     *
     * @param storeUserProfile 用户标签及其权重
     */
    void insertOrUpdateStoreUserProfileWithWeight2(UserProfile storeUserProfile);

    /**
     * 插入或更新用户标签及其权重。
     * 如果标签已存在，则权重加3；否则插入新标签并设置权重为3。
     *
     * @param storeUserProfile 用户标签及其权重
     */
    void insertOrUpdateStoreUserProfileWithWeight3(UserProfile storeUserProfile);

    /**
     * 根据用户ID获取所有用户标签及其权重。
     *
     * @param userId 用户ID
     * @return 用户标签及其权重列表
     */
    List<UserProfile> getStoreUserProfilesByUserId(int userId);
}
