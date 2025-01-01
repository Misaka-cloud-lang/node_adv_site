package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.AdvPlace;

import java.util.Collection;

public interface AdPlaceRecorderService {
    void addPlaceRecord(AdvPlace advPlace);
    default void addPlaceRecords(Collection<AdvPlace> advPlaces){
        advPlaces.forEach(this::addPlaceRecord);
    }
}
