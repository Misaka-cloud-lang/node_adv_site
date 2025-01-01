package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.AdvPlace;
import org.example.advertisement_system.mapper.AdvPlaceMapper;
import org.example.advertisement_system.service.AdPlaceRecorderService;
import org.example.advertisement_system.service.AdPlacementService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvPlaceRecorderServiceImpl implements AdPlaceRecorderService {
    @Autowired
    private AdvPlaceMapper advPlaceMapper;
    @Override
    public void addPlaceRecord(AdvPlace advPlace) {


    }
}
