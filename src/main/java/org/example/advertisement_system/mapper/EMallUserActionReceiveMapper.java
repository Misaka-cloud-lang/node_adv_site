package org.example.advertisement_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.advertisement_system.entity.UserProfile;

/**
 * @see org.example.advertisement_system.entity.UserProfile
 */
@Mapper
public interface EMallUserActionReceiveMapper {
    void insertEMallUserAction(UserProfile profile);

}
