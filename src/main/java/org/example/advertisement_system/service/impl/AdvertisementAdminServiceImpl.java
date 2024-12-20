package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.mapper.AdvertisementAdminMapper;
import org.example.advertisement_system.service.AdvertisementAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementAdminServiceImpl implements AdvertisementAdminService {

    @Autowired
    private AdvertisementAdminMapper advertisementAdminMapper;

    @Override
    public List<Advertisement> getAllAdvertisements() {
        return advertisementAdminMapper.findAll();
    }

    @Override
    public void deleteAdvertisement(String title) {
        advertisementAdminMapper.deleteByTitle(title);
    }
}
