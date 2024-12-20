package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAdvertisementsByUsername(String name);
    void deleteAdvertisement(String title);
    void addAdvertisement(Advertisement advertisement);
}
