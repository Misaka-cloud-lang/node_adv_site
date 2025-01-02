package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.mapper.AdvClickMapper;
import org.example.advertisement_system.mapper.AdvPlaceMapper;
import org.example.advertisement_system.mapper.AdvertisementMapper;
import org.example.advertisement_system.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;
    @Autowired
    private AdvClickMapper advClickMapper;

    @Autowired
    private AdvPlaceMapper advPlaceMapper;
    @Override
    public List<Advertisement> getAdvertisementsByUsername(String username) {
        return advertisementMapper.findByUsername(username);
    }

    @Override
    public void deleteAdvertisement(String title) {
        advertisementMapper.deleteByTitle(title);
    }

    @Override
    public void addAdvertisement(Advertisement advertisement) {
        advertisementMapper.insert(advertisement);
    }

    @Override
    public Advertisement getAdvertisementsByTitle(String title) {
        return advertisementMapper.findByTitle(title);
    }

    @Override
    public List<Advertisement> getAdvertisementsByTag(String tag) {
        return advertisementMapper.findByTag(tag);
    }

    @Override
    public List<Advertisement> getAdvertisementsByLocation( String location) {
        return advertisementMapper.findByLocation(location);
    }
    @Override
    public List<Advertisement> getAdvertisementsByTagAndLocation(String tag, String location) {
        return advertisementMapper.findByTagAndLocation(tag, location);
    }
    @Override
    public double getClickRate(String title) {
        int clickCount = advClickMapper.getClickCountByTitle(title);
        int placeCount = advPlaceMapper.getPlaceCountByTitle(title);
        if (placeCount == 0) {
            return 0;
        }
        return ((double) clickCount) / placeCount;
    }

    @Override
    public void setClickRate(String title, double clickRate) {
        Advertisement advertisement = advertisementMapper.findByTitle(title);
        if (advertisement != null) {
            advertisement.setClickRate(clickRate);
            advertisementMapper.updateAdvertisementPerformance(advertisement);
        }
    }
}
