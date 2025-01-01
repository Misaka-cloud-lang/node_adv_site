package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.AdvPlace;
import org.example.advertisement_system.entity.Advertisement;

import java.util.Collection;

public interface AdPlaceRecorderService {
    void addPlaceRecord(Advertisement advPlace,int site);
    default void addPlaceRecords(Collection<Advertisement> advPlaces,int site){
        advPlaces.forEach(advPlace -> addPlaceRecord(advPlace,site));
    }
}
