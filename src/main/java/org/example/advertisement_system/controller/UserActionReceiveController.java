package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.mapper.NewsUserProfileMapper;
import org.example.advertisement_system.mapper.StoreUserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户行为接收控制器，接收用户的新闻网站和网店网站行为。<br/>
 * 通过接收用户行为，更新用户画像。<br/>
 * 通过用户画像，为用户推荐广告。<br/>
 * 通过广告投放策略，为用户匹配广告。<br/>
 */
@RestController
@RequestMapping("/receive")
public class UserActionReceiveController {

    @Autowired
    private NewsUserProfileMapper newsUserProfileMapper;

    @Autowired
    private StoreUserProfileMapper storeUserProfileMapper;

    /**
     * 接收用户的新闻网站行为
     * @param userId 用户id（转发cookie）
     * @param tag 对用户访问的页面内容事先打好的标签
     * @param tag_value 标签的权重
     */

    @PostMapping("/news")
    public ResponseEntity<UserProfile> receiveNewsSiteAction(
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
        switch ((int)tag_value){
            case 1:
                newsUserProfileMapper.insertOrUpdateUserProfile(profile);
                break;
            default:
                System.err.println("bad request");
                return ResponseEntity.badRequest().body(profile);
        }
        System.out.println("receive news_site action");
        System.out.println(profile);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/emall")
    public ResponseEntity<UserProfile> receiveEMallSiteAction(
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
//        eMallUserActionReceiveMapper.insertEMallUserAction(profile);
        switch ((int)tag_value){
            case 1:
                newsUserProfileMapper.insertOrUpdateUserProfile(profile);
                break;
            case 2:
                storeUserProfileMapper.insertOrUpdateStoreUserProfileWithWeight2(profile);
                break;
            case 3:
                storeUserProfileMapper.insertOrUpdateStoreUserProfileWithWeight3(profile);
                break;
            default:
                System.out.println("bad request");
                return ResponseEntity.badRequest().body(profile);

        }
        System.out.println("receive store action");
        System.out.println(profile);
        return ResponseEntity.ok(profile);

    }
}
