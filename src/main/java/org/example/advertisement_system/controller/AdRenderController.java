package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 广告渲染控制器，处理广告渲染请求后交付投放。
 *
 * @author jyl
 */
@Controller
@RequestMapping("/api/ad")
public class AdRenderController implements EffectCodingsForSite {
    @Autowired
    private AdPlacementService adPlacementService;
    @Autowired
    private NewsUserProfileService newsUserProfileService;
    @Autowired
    private StoreUserProfileService storeUserProfileService;
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private AdPlaceRecorderService adPlaceRecorderService;

    @GetMapping("/news")
    public String renderNewsAd(
            @RequestParam(name = "userId", defaultValue = "1") int userId,
            @RequestParam(name = "adLocation", defaultValue = "0") int adLocation,
            Model model
    ) {
        List<UserProfile> profile = newsUserProfileService.getUserProfilesByUserId(userId);
        List<Advertisement> newsAds = adPlacementService.getNewsAdPlacements(userId, profile);
        int adId = adLocation % newsAds.size();
        System.err.println("选择第" + adId + "个广告");
        Advertisement advertisement = newsAds.get(adId);
        adPlaceRecorderService.addPlaceRecord(advertisement, NEWS);
        advertisementService.updateClickRate(advertisement.getTitle());
        model.addAttribute("ad", advertisement);
        return "adIframe";
    }

    @GetMapping("/store")
    public String renderStoresAd(
            @RequestParam(name = "userId", defaultValue = "1") int userId,
            @RequestParam(name = "adLocation", defaultValue = "0") int adLocation,
            Model model
    ) {
        List<UserProfile> profile = storeUserProfileService.getStoreUserProfilesByUserId(userId);
        List<Advertisement> newsAds = adPlacementService.getNewsAdPlacements(userId, profile);
        Advertisement advertisement = newsAds.get(adLocation % newsAds.size());
        adPlaceRecorderService.addPlaceRecord(advertisement, STORE);
        model.addAttribute("ad", advertisement);
        return "adIframe";
    }

}
