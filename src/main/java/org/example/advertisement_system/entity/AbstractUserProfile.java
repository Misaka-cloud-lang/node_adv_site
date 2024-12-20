package org.example.advertisement_system.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 抽象用户画像类，包含所有网站共有的用户画像信息。
 */
public abstract class AbstractUserProfile {
    /**
     * 用户唯一标识符。
     */
    protected Long userId;

    /**
     * 用户注册日期。
     */
    protected LocalDateTime registrationDate;

    /**
     * 用户最后登录日期。
     */
    protected LocalDateTime lastLoginDate;

    /**
     * 用户浏览记录列表。
     */
    protected List<BrowsingRecord> browsingHistory;

    /**
     * 用户标签权重映射表，键为标签名称，值为标签权重。
     */
    protected Map<String, Integer> tagWeights;

    /**
     * 构造方法，初始化标签权重映射表。
     */
    public AbstractUserProfile() {
        this.tagWeights = new HashMap<>();
    }

    /**
     * 更新指定标签的权重。
     *
     * @param tag 标签名称。
     * @param increment 权重增量。
     */
    protected void updateTagWeight(String tag, int increment) {
        if (increment > 0) {
            tagWeights.put(tag, tagWeights.getOrDefault(tag, 0) + increment);
        }
    }

    // Getters and Setters

    /**
     * 获取用户唯一标识符。
     *
     * @return 用户唯一标识符。
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户唯一标识符。
     *
     * @param userId 用户唯一标识符。
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户注册日期。
     *
     * @return 用户注册日期。
     */
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    /**
     * 设置用户注册日期。
     *
     * @param registrationDate 用户注册日期。
     */
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * 获取用户最后登录日期。
     *
     * @return 用户最后登录日期。
     */
    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 设置用户最后登录日期。
     *
     * @param lastLoginDate 用户最后登录日期。
     */
    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 获取用户浏览记录列表。
     *
     * @return 用户浏览记录列表。
     */
    public List<BrowsingRecord> getBrowsingHistory() {
        return browsingHistory;
    }

    /**
     * 设置用户浏览记录列表。
     *
     * @param browsingHistory 用户浏览记录列表。
     */
    public void setBrowsingHistory(List<BrowsingRecord> browsingHistory) {
        this.browsingHistory = browsingHistory;
    }

    /**
     * 获取用户标签权重映射表。
     *
     * @return 用户标签权重映射表。
     */
    public Map<String, Integer> getTagWeights() {
        return tagWeights;
    }

    /**
     * 设置用户标签权重映射表。
     *
     * @param tagWeights 用户标签权重映射表。
     */
    public void setTagWeights(Map<String, Integer> tagWeights) {
        this.tagWeights = tagWeights;
    }
}

/**
 * 浏览记录类，记录用户访问的网页信息。
 */
class BrowsingRecord {
    /**
     * 访问的网站名称。
     */
    private String website;

    /**
     * 访问的URL。
     */
    private String url;

    /**
     * 访问的时间戳。
     */
    private LocalDateTime timestamp;

    // Getters and Setters

    /**
     * 获取访问的网站名称。
     *
     * @return 访问的网站名称。
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 设置访问的网站名称。
     *
     * @param website 访问的网站名称。
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * 获取访问的URL。
     *
     * @return 访问的URL。
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问的URL。
     *
     * @param url 访问的URL。
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取访问的时间戳。
     *
     * @return 访问的时间戳。
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 设置访问的时间戳。
     *
     * @param timestamp 访问的时间戳。
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}