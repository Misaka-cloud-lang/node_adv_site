package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.mapper.EMallUserActionReceiveMapper;
import org.example.advertisement_system.mapper.NewsSiteUserActionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive")
public class UserActionReceiveController {
    @Autowired
    private NewsSiteUserActionMapper newsSiteUserActionMapper;

    @Autowired
    private EMallUserActionReceiveMapper eMallUserActionReceiveMapper;

    /**
     * 接收用户的新闻网站行为
     * @param userId 用户id（转发cookie）
     * @param tag 对用户访问的页面内容事先打好的标签
     * @param tag_value 标签的权重
     */

    @PostMapping("/news")
    public void receiveNewsSiteAction(
            @RequestParam(name="userId",defaultValue = "-1")
            int userId,
            @RequestParam(name="tag",defaultValue = "Unknown")
            String tag,
            @RequestParam(name="action",defaultValue = "1")
            float tag_value
    ){
        UserProfile profile = new UserProfile();
        profile.setUserId(userId);
        profile.setTagName(tag);
        profile.setTagWeight(tag_value);
        newsSiteUserActionMapper.insertUserAction(profile);
        System.out.println("receive news_site action");
        System.out.println(profile);
    }

    @PostMapping("/emall")
    public void receiveEMallSiteAction(
            @RequestParam(name="userId",defaultValue = "-1")
            int userId,
            @RequestParam(name="tag",defaultValue = "Unknown")
            String tag,
            @RequestParam(name="action",defaultValue = "1")
            float tag_value
    ){
        UserProfile profile = new UserProfile();
        profile.setUserId(userId);
        profile.setTagName(tag);
        profile.setTagWeight(tag_value);
        eMallUserActionReceiveMapper.insertEMallUserAction(profile);
        System.out.println("receive emall action");
        System.out.println(profile);

    }
}
