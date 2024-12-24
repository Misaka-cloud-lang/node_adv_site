package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.Advertisement;

import java.util.List;

/**
 * 广告服务接口，定义了广告相关的业务操作。
 */
public interface AdvertisementService {
    /**
     * 根据用户名获取广告列表。
     *
     * @param name 用户名
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByUsername(String name);

    /**
     * 根据标题删除广告。
     *
     * @param title 广告标题
     */
    void deleteAdvertisement(String title);

    /**
     * 添加新的广告。
     *
     * @param advertisement 广告对象
     */
    void addAdvertisement(Advertisement advertisement);

    /**
     * 根据标题获取广告列表。
     *
     * @param title 广告标题
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByTitle(String title);

    /**
     * 根据单个标签获取广告列表。
     *
     * @param tag 广告的单个标签
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByTag(String tag);
}
