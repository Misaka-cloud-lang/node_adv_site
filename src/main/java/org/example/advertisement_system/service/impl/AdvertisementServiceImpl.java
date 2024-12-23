package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.mapper.AdvertisementMapper;
import org.example.advertisement_system.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;

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
    public List<Advertisement> getAdvertisementsByTitle(String title) {
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

}
