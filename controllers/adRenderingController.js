// controllers/adRenderingController.js
const express = require('express');
const router = express.Router();

const {
  getRandomAd,
  trackImpression,
  trackClick,
  getAdById
} = require('../services/adRenderingService');

/**
 * 示例：获取一个随机广告
 * GET /render/getAd?userId=U001&siteType=news
 */
router.get('/getAd', async (req, res) => {
  try {
    const { userId, siteType } = req.query;
    const ad = await getRandomAd();
    if (!ad) {
      return res.json({ success: false, message: 'No available ad found' });
    }
    return res.json({
      success: true,
      adId: ad.id,
      title: ad.title,
      description: ad.description,
      imageUrl: ad.imageUrl,
      targetUrl: ad.targetUrl,
      category: ad.category,
      userId: userId || null,
      siteType: siteType || 'news'
    });
  } catch (error) {
    console.error('Error in getAd:', error);
    return res.status(500).json({ success: false, message: error.message });
  }
});

/**
 * 记录曝光
 * POST /render/trackImpression
 * body: { adId, userId, siteType }
 */
router.post('/trackImpression', async (req, res) => {
  try {
    const { adId, userId, siteType } = req.body;
    await trackImpression(adId, userId, siteType);
    return res.json({ success: true, message: 'Impression tracked' });
  } catch (error) {
    console.error('Error in trackImpression:', error);
    return res.status(500).json({ success: false, message: error.message });
  }
});

/**
 * 记录点击
 * POST /render/trackClick
 * body: { adId, userId, siteType }
 */
router.post('/trackClick', async (req, res) => {
  try {
    const { adId, userId, siteType } = req.body;
    await trackClick(adId, userId, siteType);
    return res.json({ success: true, message: 'Click tracked' });
  } catch (error) {
    console.error('Error in trackClick:', error);
    return res.status(500).json({ success: false, message: error.message });
  }
});

/**
 * 根据广告ID获取广告 (可用于单独预览、编辑等)
 * GET /render/ad/1
 */
router.get('/ad/:adId', async (req, res) => {
  try {
    const { adId } = req.params;
    const ad = await getAdById(adId);
    if (!ad) {
      return res.json({ success: false, message: 'Ad not found' });
    }
    return res.json({
      success: true,
      adId: ad.id,
      title: ad.title,
      description: ad.description,
      imageUrl: ad.imageUrl,
      targetUrl: ad.targetUrl,
      category: ad.category
    });
  } catch (error) {
    console.error('Error in getAdById:', error);
    return res.status(500).json({ success: false, message: error.message });
  }
});

module.exports = router;
