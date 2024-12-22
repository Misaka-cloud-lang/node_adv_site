// services/adAnalysisService.js
const AdImpression = require('../models/adImpression');
const AdClick = require('../models/adClick');
const { Op } = require('sequelize');

/**
 * 分析某段时间内，某广告(或全部广告)的曝光数、点击数、CTR
 */
async function getPerformanceData(adId, startTime, endTime) {
  const impressionWhere = {};
  const clickWhere = {};

  // 如果指定了广告 ID
  if (adId) {
    impressionWhere.adId = adId;
    clickWhere.adId = adId;
  }

  // 如果指定了时间范围
  if (startTime && endTime) {
    impressionWhere.impressionTime = { [Op.between]: [startTime, endTime] };
    clickWhere.clickTime = { [Op.between]: [startTime, endTime] };
  }

  // 分别统计曝光、点击数量
  const impressionsCount = await AdImpression.count({ where: impressionWhere });
  const clicksCount = await AdClick.count({ where: clickWhere });

  // CTR = (点击数 / 曝光数) * 100
  let ctr = 0;
  if (impressionsCount > 0) {
    ctr = (clicksCount / impressionsCount) * 100;
  }

  return {
    adId: adId || 'ALL',
    impressions: impressionsCount,
    clicks: clicksCount,
    ctr: ctr.toFixed(2) + '%'
  };
}

module.exports = {
  getPerformanceData
};
