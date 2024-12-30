package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.Advertisement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 广告添加控制器，处理广告添加请求并返回添加广告页面。
 * @author jyl
 */
@Controller
public class AdvAddController {
    @GetMapping("/addAdv")
    public String renderAddAdvertisement(
            @RequestParam(name = "name", defaultValue = "1") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "addAdv";
    }


}
