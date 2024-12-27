package org.example.advertisement_system.entity;

public interface Tags {


    String NEWS_DOMESTIC = "domestic";

    String NEWS_INTERNATIONAL = "international";

    String NEWS_SPORTS = "sports";

    String NEWS_TECHNOLOGY = "technology";

    String NEWS_ENTERTAINMENT = "entertainment";

    String NEWS_FINANCE = "finance";

    String NEWS_MILITARY = "military";

    String NEWS_SOCIETY = "society";

    String NEWS_STOCK_MARKET = "stockMarket";

    String NEWS_US_STOCK_MARKET = "usStockMarket";
    /**
     * 新闻网站用户标签数组。
     */
    String[]
            NEWS_USER_TAGS = {
            NEWS_DOMESTIC,
            NEWS_INTERNATIONAL,
            NEWS_SPORTS,
            NEWS_TECHNOLOGY,
            NEWS_ENTERTAINMENT,
            NEWS_FINANCE,
            NEWS_MILITARY,
            NEWS_SOCIETY,
            NEWS_STOCK_MARKET,
            NEWS_US_STOCK_MARKET
    };

    /**
     * 网店网站用户标签数组。
     */
    String[] STORE_USER_TAGS = {"electronicProducts", "homeGoods", "clothing", "foodProducts", "books", "beautyProducts", "sportsEquipment", "carAccessories", "travelSupplies"};


}
