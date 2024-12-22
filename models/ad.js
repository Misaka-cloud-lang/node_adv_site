const { DataTypes } = require('sequelize');
const { sequelize } = require('../config/db');

const Ad = sequelize.define('Ad', {
  id: {
    type: DataTypes.INTEGER,
    autoIncrement: true,
    primaryKey: true
  },
  title: { type: DataTypes.STRING, allowNull: false },
  description: { type: DataTypes.TEXT },
  imageUrl: { type: DataTypes.STRING },
  targetUrl: { type: DataTypes.STRING },
  category: { type: DataTypes.STRING }
}, {
  tableName: 'ads'
});

module.exports = Ad;
