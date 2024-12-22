const { DataTypes } = require('sequelize');
const { sequelize } = require('../config/db');
const Ad = require('./ad');

const AdImpression = sequelize.define('AdImpression', {
  id: {
    type: DataTypes.INTEGER,
    autoIncrement: true,
    primaryKey: true
  },
  // 指向哪个广告
  adId: {
    type: DataTypes.INTEGER,
    references: {
      model: Ad,
      key: 'id'
    }
  },
  // 用户ID，如未登录则可存null或随机ID
  userId: { type: DataTypes.STRING, allowNull: true },
  // 记录曝光所在站点，如news、shop等
  siteType: { type: DataTypes.STRING },
  impressionTime: { type: DataTypes.DATE, defaultValue: DataTypes.NOW }
}, {
  tableName: 'ad_impressions'
});

module.exports = AdImpression;
