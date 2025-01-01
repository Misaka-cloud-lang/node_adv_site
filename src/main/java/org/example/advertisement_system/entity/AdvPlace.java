package org.example.advertisement_system.entity;

import java.time.LocalDateTime;

public class AdvPlace {
    private LocalDateTime placeTime;
    private String advTitle;
    private int placeSite;

    // Getters and Setters
    public LocalDateTime getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(LocalDateTime placeTime) {
        this.placeTime = placeTime;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public int getPlaceSite() {
        return placeSite;
    }

    public void setPlaceSite(int placeSite) {
        this.placeSite = placeSite;
    }
}