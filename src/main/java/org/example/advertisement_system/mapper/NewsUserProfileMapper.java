package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.*;
import org.example.advertisement_system.entity.UserProfile;

import java.util.List;

/**
 * 用户标签及其权重的 MyBatis Mapper 接口。
 */
@Mapper
public interface NewsUserProfileMapper {

    /**
     * 插入或更新用户标签及其权重。
     * 如果标签已存在，则权重加1；否则插入新标签并设置权重为1。
     *
     * @param userProfile 用户标签及其权重
     */
    void insertOrUpdateUserProfile(UserProfile userProfile);
    /**
     * 根据用户ID获取所有用户标签及其权重。
     *
     * @param userId 用户ID
     * @return 用户标签及其权重列表
     */
    List<UserProfile> getUserProfilesByUserId(int userId);
}
