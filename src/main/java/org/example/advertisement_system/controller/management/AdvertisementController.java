package org.example.advertisement_system.controller.management;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <strong>{@link RestController}只传数据，不能渲染网页</strong><br/>
 * 广告控制器，处理广告请求。
 */
@RestController
@RequestMapping("/api/operating")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;



    @GetMapping("/advertisements")
    public List<Advertisement> getAdvertisementsByUsername(@RequestParam String username) {
        return advertisementService.getAdvertisementsByUsername(username);
    }

    @DeleteMapping("/by-title/{title}") // 新增删除广告的端点
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable String title) {
        advertisementService.deleteAdvertisement(title);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/advertisements")
    public ResponseEntity<String> addAdvertisement(@RequestBody Advertisement advertisement) {
        advertisementService.addAdvertisement(advertisement);
        return ResponseEntity.ok("广告已成功添加");
    }

    @GetMapping("/advertisements_title")
    public List<Advertisement> getAdvertisementsByTitle(@RequestParam String title) {
        return advertisementService.getAdvertisementsByTitle(title);
    }

    @GetMapping("/advertisements_tag")
    public List<Advertisement> getAdvertisementsByTagAndLocation(@RequestParam String tag, @RequestParam String location) {
        return advertisementService.getAdvertisementsByTagAndLocation(tag, location);
    }
}