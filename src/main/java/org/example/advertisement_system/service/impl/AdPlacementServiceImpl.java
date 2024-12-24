package org.example.advertisement_system.service.impl;

import org.example.advertisement_system.entity.Advertisement;
import org.example.advertisement_system.entity.UserProfile;
import org.example.advertisement_system.service.AdPlacementService;
import org.example.advertisement_system.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 广告投放服务实现类，实现了根据用户标签和广告投放策略获取匹配广告的操作。
 */
@Service
public class AdPlacementServiceImpl implements AdPlacementService {

    @Autowired
    private AdvertisementService advertisementService;

    private static final String LOCATION_NEWS = "新闻";
    private static final String LOCATION_STORE = "网店";
    // 在类中定义一个成员变量用于存储每次投放广告的数量，初始化为默认值
    private int numberOfAdsToPlace = 2;
    private final Map<String, Map<String, Double>> newsAssociationMatrix = new HashMap<>();
    private final Map<String, Map<String, Double>> storeAssociationMatrix = new HashMap<>();

    /**
     * 构造函数，初始化关联矩阵。
     */
    public AdPlacementServiceImpl() {
        // 初始化新闻网站关联矩阵
        for (String userTag : UserProfile.NEWS_USER_TAGS) {
            Map<String, Double> categoryWeights = new HashMap<>();
            for (String category : Advertisement.NEWS_ADVERTISEMENT_CATEGORIES) {
                double weight = calculateNewsAssociationWeight(userTag, category);
                categoryWeights.put(category, weight);
            }
            newsAssociationMatrix.put(userTag, categoryWeights);
        }

        // 初始化网店网站关联矩阵
        for (String userTag : UserProfile.STORE_USER_TAGS) {
            Map<String, Double> categoryWeights = new HashMap<>();
            for (String category : Advertisement.STORE_ADVERTISEMENT_CATEGORIES) {
                double weight = calculateStoreAssociationWeight(userTag, category);
                categoryWeights.put(category, weight);
            }
            storeAssociationMatrix.put(userTag, categoryWeights);
        }
    }

    /**
     * 计算新闻网站用户标签和广告分类之间的关联权重。
     *
     * @param userTag 用户标签
     * @param category 广告分类
     * @return 关联权重
     */
    private double calculateNewsAssociationWeight(String userTag, String category) {
        // 根据提供的规则计算权重
        switch (userTag) {
            case "technology":
                switch (category) {
                    case "电子产品":
                        return 1.0;
                    case "娱乐":
                        return 0.8;
                    case "国内":
                        return 0.5;
                    case "国际":
                        return 0.5;
                    default:
                        return 0.2;
                }
            case "entertainment":
                switch (category) {
                    case "美妆":
                        return 0.9;
                    case "科技":
                        return 0.8;
                    default:
                        return 0.2;
                }
            case "society":
                switch (category) {
                    case "公益":
                        return 1.0;
                    default:
                        return 0.2;
                }
            case "domestic":
                switch (category) {
                    case "公益":
                        return 0.9;
                    case "金融":
                        return 0.5;
                    case "汽车":
                        return 0.5;
                    default:
                        return 0.2;
                }
            case "international":
                switch (category) {
                    case "公益":
                        return 0.8;
                    case "金融":
                        return 0.5;
                    case "汽车":
                        return 0.5;
                    default:
                        return 0.2;
                }
            case "sports":
                switch (category) {
                    case "公益":
                        return 0.6;
                    default:
                        return 0.2;
                }
            case "finance":
                switch (category) {
                    case "金融":
                        return 1.0;
                    default:
                        return 0.2;
                }
            case "stockMarket":
                switch (category) {
                    case "金融":
                        return 1.0;
                    default:
                        return 0.2;
                }
            case "usStockMarket":
                switch (category) {
                    case "金融":
                        return 1.0;
                    default:
                        return 0.2;
                }
            case "military":
                switch (category) {
                    case "汽车":
                        return 1.0;
                    default:
                        return 0.2;
                }
            default:
                return 0.2;
        }
    }


    /**
     * 计算网店网站用户标签和广告分类之间的关联权重。
     *
     * @param userTag 用户标签
     * @param category 广告分类
     * @return 关联权重
     */
    private double calculateStoreAssociationWeight(String userTag, String category) {
        // 这里可以根据实际业务逻辑来计算权重
        // 示例中使用简单的规则
        if (userTag.equals(category)) {
            return 1.0;
        } else if (userTag.equals("电子产品") && category.equals("科技")) {
            return 0.8;
        } else if (userTag.equals("科技") && category.equals("电子产品")) {
            return 0.8;
        } else if (userTag.equals("家居用品") && category.equals("家居用品")) {
            return 1.0;
        } else if (userTag.equals("服装") && category.equals("时尚")) {
            return 0.7;
        } else if (userTag.equals("食品") && category.equals("健康")) {
            return 0.6;
        } else if (userTag.equals("图书") && category.equals("教育")) {
            return 0.7;
        } else if (userTag.equals("美妆") && category.equals("美妆")) {
            return 1.0;
        } else if (userTag.equals("运动器材") && category.equals("运动")) {
            return 0.8;
        } else if (userTag.equals("汽车用品") && category.equals("汽车")) {
            return 0.9;
        } else if (userTag.equals("旅行用品") && category.equals("旅行")) {
            return 0.8;
        } else {
            return 0.1;
        }
    }

    /**
     * 根据新闻网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId           用户ID
     * @param newsUserProfiles 新闻用户标签及其权重列表
     * @return 匹配的广告列表
     */
    @Override
    public List<Advertisement> getNewsAdPlacements(int userId, List<UserProfile> newsUserProfiles) {
        Map<String, Double> categoryScores = new HashMap<>();

        // 计算每个广告分类的匹配得分
        for (UserProfile userProfile : newsUserProfiles) {
            String userTag = userProfile.getTagName();
            float userTagWeight = userProfile.getTagWeight();

            if (newsAssociationMatrix.containsKey(userTag)) {
                for (Map.Entry<String, Double> associationEntry : newsAssociationMatrix.get(userTag).entrySet()) {
                    String category = associationEntry.getKey();
                    Double associationValue = associationEntry.getValue();

                    categoryScores.put(category, categoryScores.getOrDefault(category, 0.0) + userTagWeight * associationValue);
                    System.out.println("用户标签：" + userTag + "，广告分类：" + category + "，匹配得分：" + userTagWeight * associationValue);
                }
            }
        }
        // 输出每个广告分类的总得分
        System.out.println("每个广告分类的总得分：");
        for (Map.Entry<String, Double> entry : categoryScores.entrySet()) {
            System.out.println("广告分类：" + entry.getKey() + "，总得分：" + entry.getValue());
        }
        // 如果 categoryScores 为空，说明没有匹配的标签
        if (categoryScores.isEmpty()) {
            System.out.println("没有匹配标签，进行随机抽取");
            // 如果没有匹配的标签，对所有广告进行随机抽取
            return getRandomAdvertisements(LOCATION_NEWS);
        }

        // 找到匹配得分最高的广告分类
        double maxScore = categoryScores.values().stream().max(Double::compare).orElse(0.0);
        List<String> bestCategories = categoryScores.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //输出匹配的广告分类
        System.out.println("匹配的广告分类：" );
        for(String category : bestCategories){
            System.out.println(category);
        }

        // 从广告池中筛选具体广告
        List<Advertisement> advertisements = new ArrayList<>();
        for (String category : bestCategories) {
            advertisements.addAll(advertisementService.getAdvertisementsByTagAndLocation(category, LOCATION_NEWS));
        }

        // 随机投放广告
        Collections.shuffle(advertisements);
        return advertisements.subList(0, Math.min(numberOfAdsToPlace, advertisements.size()));
    }

    /**
     * 从指定位置随机抽取广告。
     *
     * @param location 网站新闻/网店
     * @return 随机抽取的广告列表
     */
    private List<Advertisement> getRandomAdvertisements(String location) {
        List<Advertisement> allAdvertisements = advertisementService.getAdvertisementsByLocation(location);
        Collections.shuffle(allAdvertisements);
        return allAdvertisements.subList(0, Math.min(numberOfAdsToPlace, allAdvertisements.size()));
    }




    /**
     * 根据网店网站用户标签和广告投放策略获取匹配的广告。
     *
     * @param userId            用户ID
     * @param storeUserProfiles 商店用户标签及其权重列表
     * @return 匹配的广告列表
     */
    @Override
    public List<Advertisement> getStoreAdPlacements(int userId, List<UserProfile> storeUserProfiles) {
        Map<String, Double> categoryScores = new HashMap<>();

        // 计算每个广告分类的匹配得分
        for (UserProfile userProfile : storeUserProfiles) {
            String userTag = userProfile.getTagName();
            float userTagWeight = userProfile.getTagWeight();

            if (storeAssociationMatrix.containsKey(userTag)) {
                for (Map.Entry<String, Double> associationEntry : storeAssociationMatrix.get(userTag).entrySet()) {
                    String category = associationEntry.getKey();
                    Double associationValue = associationEntry.getValue();

                    categoryScores.put(category, categoryScores.getOrDefault(category, 0.0) + userTagWeight * associationValue);
                }
            }
        }

        // 选择匹配得分最高的广告分类
        String bestCategory = categoryScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");

        // 从广告池中筛选具体广告
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByTagAndLocation(bestCategory, LOCATION_STORE);

        // 随机投放广告
        Collections.shuffle(advertisements);
        return advertisements.subList(0, Math.min(numberOfAdsToPlace, advertisements.size()));
    }
}
