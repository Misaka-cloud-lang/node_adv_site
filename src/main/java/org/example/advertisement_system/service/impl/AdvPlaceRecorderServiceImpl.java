package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.AdvPlace;
import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.mapper.AdvPlaceMapper;
import org.example.advertisement_system.service.AdPlaceRecorderService;
import org.example.advertisement_system.service.AdPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdvPlaceRecorderServiceImpl implements AdPlaceRecorderService {
    @Autowired
    private AdvPlaceMapper advPlaceMapper;
    @Override
    public void addPlaceRecord(Advertisement adv,int site) {
        AdvPlace advPlace = new AdvPlace();
        advPlace.setAdvTitle(adv.getTitle());
        advPlace.setPlaceSite(site);
        advPlace.setPlaceTime(LocalDateTime.now());
        advPlaceMapper.insertAdvPlace(advPlace);
    }
}
