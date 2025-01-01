package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.AdvClick;
import org.example.advertisement_system.mapper.AdvClickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/effect")
public class AdEffectController implements EffectCodingsForSite{

    @Autowired
    AdvClickMapper advClickMapper;

    @PostMapping("/news")
    public ResponseEntity<AdvClick> reportStoreAdClick(
            @RequestParam(name="title",defaultValue = "Unknown")
            String title
    ) {
        AdvClick advClick = new AdvClick();
        advClick.setAdvTitle(title);
        advClick.setPlaceSite(NEWS);
        advClickMapper.insertAdvClick(advClick);
        return ResponseEntity.ok(advClick);
    }

    @PostMapping("/store")
    public ResponseEntity<AdvClick> reportNewsAdClick(
            @RequestParam(name="title",defaultValue = "Unknown")
            String title
    ) {
        AdvClick advClick = new AdvClick();
        advClick.setAdvTitle(title);
        advClick.setPlaceSite(STORE);
        advClickMapper.insertAdvClick(advClick);
        return ResponseEntity.ok(advClick);
    }
}
