package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/manage")
public class AdSubmissionController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/advertisements")
    public ResponseEntity<String> addAdvertisement(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("tag") String tag,
            @RequestParam("username") String username,
            @RequestParam("time") LocalDateTime time,
            @RequestParam("location") String location,
            @RequestParam("picture") MultipartFile picture
    ) {
        try {
            // Save the picture to a relative directory
            String uploadDir = "uploads"; // relative path
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String pictureFilename = picture.getOriginalFilename();
            if (pictureFilename == null) {
                return ResponseEntity.badRequest().body("图片文件名不能为空");
            }
            Path filePath = uploadPath.resolve(pictureFilename);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                Files.copy(picture.getInputStream(), filePath);
            }

            // Create the advertisement object
            Advertisement advertisement = new Advertisement();
            advertisement.setTitle(title);
            advertisement.setContent(content);
            advertisement.setTag(tag);
            advertisement.setUsername(username);
            advertisement.setTime(time);
            advertisement.setLocation(location);
            advertisement.setPicture(uploadDir + "/" + pictureFilename);

            // Save the advertisement
            advertisementService.addAdvertisement(advertisement);
            return ResponseEntity.ok("广告已成功添加");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("广告添加失败");
        }
    }

    @GetMapping("/pictures/{filename}")
    public ResponseEntity<Resource> getPicture(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("uploads").resolve(filename).normalize();
            System.out.println(filePath);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}