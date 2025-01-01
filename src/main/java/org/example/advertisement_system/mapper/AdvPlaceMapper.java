package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.advertisement_system.entity.AdvPlace;

@Mapper
public interface AdvPlaceMapper {

    void insertAdvPlace(AdvPlace advPlace);

}