package org.example.advertisement_system.entity;
import java.util.List;

/**
 * 新闻网站用户画像类，继承自抽象用户画像类，包含新闻网站特有的用户画像信息。
 */
public class NewsUserProfile extends AbstractUserProfile {

    /**
     * 更新新闻分类标签的权重。
     *
     * @param category 新闻分类标签。
     */
    public void updateCategoryWeight(String category) {
        super.updateTagWeight(category, 1); // 每次点击同一分类的新闻，权重加1
    }

    // Getters and Setters (如果需要额外的方法或字段)
}

