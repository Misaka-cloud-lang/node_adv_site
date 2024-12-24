package org.example.advertisement_system.entity;

import java.time.LocalDateTime;

public class Advertisement {
    private String title;
    private String content;
    private String tag;
    private String username;
    private LocalDateTime time;
    private String picture;
    private String location;   //广告投放的位置：网店/新闻
    /**
     * 新闻网站广告分类标签数组。
     */
    public static final String[] NEWS_ADVERTISEMENT_CATEGORIES = {"电子产品","美妆","公益","金融","汽车"};

    /**
     * 网店网站广告分类标签数组。
     */
    public static final String[] STORE_ADVERTISEMENT_CATEGORIES = {"电子产品", "家居用品", "服装", "食品", "图书", "美妆", "运动器材", "汽车用品", "旅行用品"};

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for tag
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for time
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    // Getter and Setter for picture
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    // Getter and Setter for location
    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}
}
