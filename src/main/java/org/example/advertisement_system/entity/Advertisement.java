package org.example.advertisement_system.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Advertisement {
    /**
     * 广告标题
     */
    private String title;
    /**
     * 广告内容
     */
    private String content;
    /**
     * 广告标签
     */
    private String tag;
    /**
     * 广告发布者
     */
    private String username;
    /**
     * 广告发布时间
     */
    private LocalDateTime time;
    /**
     * 广告图片
     */
    private String picture;
    /**
     * 广告投放的位置：网店/新闻
     */
    private String location;   //广告投放的位置：网店/新闻
    /**
     * 广告点击率
     */
    private double clickRate;
    /**
     * 新闻网站广告分类标签数组。
     */
    public static final String[] NEWS_ADVERTISEMENT_CATEGORIES = {"电子产品","美妆","公益","金融","汽车"};

    /**
     * 网店网站广告分类标签数组。
     */
    public static final String[] STORE_ADVERTISEMENT_CATEGORIES = {"电子产品", "家居用品", "服装", "食品", "图书", "美妆", "运动", "汽车","旅行"};

}
