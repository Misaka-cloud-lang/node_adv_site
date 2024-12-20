package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.advertisement_system.entity.Advertisement;

import java.util.List;

@Mapper
public interface AdvertisementAdminMapper {
    List<Advertisement> findAll();

    void deleteByTitle(@Param("title") String title);
}
