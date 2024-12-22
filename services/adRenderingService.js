// services/adRenderingService.js
const Ad = require('../models/ad');
const AdImpression = require('../models/adImpression');
const AdClick = require('../models/adClick');
const { Op } = require('sequelize');

/**
 * 随机获取一个广告 (可基于投放策略、用户画像、分类标签做更复杂筛选)
 */
async function getRandomAd() {
  const ads = await Ad.findAll();
  if (!ads.length) {
    return null;
  }
  const randomIndex = Math.floor(Math.random() * ads.length);
  return ads[randomIndex];
}

/**
 * 记录曝光
 */
async function trackImpression(adId, userId, siteType) {
  if (!adId) throw new Error('adId is required');
  return AdImpression.create({
    adId,
    userId,
    siteType
    // impressionTime 默认当前时间
  });
}

/**
 * 记录点击
 */
async function trackClick(adId, userId, siteType) {
  if (!adId) throw new Error('adId is required');
  return AdClick.create({
    adId,
    userId,
    siteType
    // clickTime 默认当前时间
  });
}

/**
 * 根据 ID 获取广告
 */
async function getAdById(adId) {
  return Ad.findByPk(adId);
}

module.exports = {
  getRandomAd,
  trackImpression,
  trackClick,
  getAdById
};
