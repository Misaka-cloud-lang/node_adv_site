package org.example.advertisement_system.entity;

/**
 * 用户标签及其权重的实体类。
 */

public class UserProfile {

    /**
     * 新闻网站用户标签数组。
     */
    public static final String[] NEWS_USER_TAGS = {"domestic", "international", "sports", "technology", "entertainment", "finance", "military","society", "stockMarket", "usStockMarket"};

    /**
     * 网店网站用户标签数组。
     */
    public static final String[] STORE_USER_TAGS = {"电子产品", "家居用品", "服装", "食品", "图书", "美妆", "运动器材", "汽车用品", "旅行用品"};

    /**
     * 用户ID。
     */
    private int userId;

    /**
     * 用户访问网站内容的标签名。
     */
    private String tagName;

    /**
     * 标签权重。
     */
    private float tagWeight;

    /**
     * 无参构造函数。
     */
    public UserProfile() {
    }

    /**
     * 带参构造函数。
     *
     * @param userId    用户ID
     * @param tagName   标签名
     * @param tagWeight 标签权重
     */
    public UserProfile(int userId, String tagName, float tagWeight) {
        this.userId = userId;
        this.tagName = tagName;
        this.tagWeight = tagWeight;
    }

    /**
     * 获取用户ID。
     *
     * @return 用户ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置用户ID。
     *
     * @param userId 用户ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取标签名。
     *
     * @return 标签名
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置标签名。
     *
     * @param tagName 标签名
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 获取标签权重。
     *
     * @return 标签权重
     */
    public float getTagWeight() {
        return tagWeight;
    }

    /**
     * 设置标签权重。
     *
     * @param tagWeight 标签权重
     */
    public void setTagWeight(float tagWeight) {
        this.tagWeight = tagWeight;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", tagName='" + tagName + '\'' +
                ", tagWeight=" + tagWeight +
                '}';
    }
}

