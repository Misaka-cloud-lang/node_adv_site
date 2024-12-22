const { DataTypes } = require('sequelize');
const { sequelize } = require('../config/db');
const Ad = require('./ad');

const AdClick = sequelize.define('AdClick', {
  id: {
    type: DataTypes.INTEGER,
    autoIncrement: true,
    primaryKey: true
  },
  adId: {
    type: DataTypes.INTEGER,
    references: {
      model: Ad,
      key: 'id'
    }
  },
  userId: { type: DataTypes.STRING, allowNull: true },
  siteType: { type: DataTypes.STRING },
  clickTime: { type: DataTypes.DATE, defaultValue: DataTypes.NOW }
}, {
  tableName: 'ad_clicks'
});

module.exports = AdClick;
