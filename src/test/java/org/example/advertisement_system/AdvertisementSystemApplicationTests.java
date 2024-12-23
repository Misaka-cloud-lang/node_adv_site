package org.example.advertisement_system;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class AdvertisementSystemApplicationTests {
    @Autowired
    private NewsUserProfileService newsUserProfileService;
    @Test
    void contextLoads() {
    }
}
