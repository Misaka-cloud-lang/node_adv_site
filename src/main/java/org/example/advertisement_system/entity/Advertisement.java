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

    // Getter and Setter for location
    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}
}
