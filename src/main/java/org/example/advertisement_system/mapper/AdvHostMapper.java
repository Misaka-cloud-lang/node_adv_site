package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.advertisement_system.entity.AdvHost;

@Mapper
public interface AdvHostMapper {
    AdvHost findByAdvHostName(@Param("username") String username);

    void insertAdvHost(AdvHost advHost);
}
