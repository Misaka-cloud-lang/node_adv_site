package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.Advertisement;

import java.util.List;

public interface AdvertisementAdminService {
    List<Advertisement> getAllAdvertisements();
    void deleteAdvertisement(String title);
}

