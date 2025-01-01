package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.advertisement_system.entity.AdvClick;

@Mapper
public interface AdvClickMapper {

    void insertAdvClick(AdvClick advClick);

}