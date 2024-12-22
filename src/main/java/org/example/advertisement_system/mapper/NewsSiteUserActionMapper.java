package org.example.advertisement_system.mapper;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.example.advertisement_system.entity.UserProfile;

/**
 * Mapper for NewsSiteUserAction
 * @see org.example.advertisement_system.entity.UserProfile
 */
@Mapper
public interface NewsSiteUserActionMapper {
    int insertUserAction(UserProfile profile);
}
