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
    Advertisement getAdvertisementsByTitle(String title);

    /**
     * 根据单个标签和投放网站获取广告列表。
     *网站：网店/新闻
     * @param tag 广告的单个标签
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByTag(String tag);

    /**
     * 根据单个标签和投放网站获取广告列表。
     *网站：网店/新闻
     * @param location 网站：网店/新闻
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByLocation( String location);
    /**
     * 根据单个标签和投放网站获取广告列表。
     *网站：网店/新闻
     * @param tag 广告的单个标签
     * @param location 网站：网店/新闻
     * @return 广告列表
     */
    List<Advertisement> getAdvertisementsByTagAndLocation(String tag, String location);

    /**
     * 根据广告标题获取点击率。
     *
     * @param title 广告标题
     * @return 点击率
     */
    double getClickRate(String title);
    /**
     * 设置广告的点击率。
     *
     * @param title     广告标题
     * @param clickRate 点击率
     */
    void setClickRate(String title, double clickRate);

    default void updateClickRate(String title) {
        double clickRate = getClickRate(title);
        setClickRate(title, clickRate);
    }

}
