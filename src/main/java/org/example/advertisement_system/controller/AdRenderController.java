package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.AdPlacementService;
import org.example.advertisement_system.service.NewsUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RequestMapping("/api/ad")
public class AdRenderController {
    @Autowired
    private AdPlacementService adPlacementService;
    @Autowired
    private NewsUserProfileService newsUserProfileService;

    @GetMapping("/news")
    public String renderNewsAd(
            @RequestParam(name = "userId", defaultValue = "1") int userId,
            Model model
    ) {
        List<UserProfile> profile = newsUserProfileService.getUserProfilesByUserId(userId);
        List<Advertisement> newsAds = adPlacementService.getNewsAdPlacements(userId, profile);
        Advertisement advertisement = newsAds.get(0);
        model.addAttribute("ad", advertisement);
        return "adIframe";
    }

}
