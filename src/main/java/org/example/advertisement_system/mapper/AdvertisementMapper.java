package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.advertisement_system.entity.Advertisement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvertisementMapper {

    List<Advertisement> findByUsername(@Param("username") String username);

    void deleteByTitle(@Param("title") String title);

    void insert(Advertisement advertisement);

    List<Advertisement> findByTitle(@Param("title") String title);

    List<Advertisement> findByTag(@Param("tag") String tag);
}
