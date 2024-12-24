// app.js
require('dotenv').config();
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const path = require('path');

const db = require('./config/db');     // Sequelize实例
const routes = require('./routes');    // 路由汇总

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(bodyParser.json());

// 提供 public 目录的静态文件
app.use(express.static(path.join(__dirname, 'public')));

// 测试数据库连接 & 同步模型
db.sequelize.authenticate()
  .then(() => {
    console.log('MySQL connected via Sequelize');
    // 同步数据表，如需每次都重建可用: db.sequelize.sync({ force: true })
    return db.sequelize.sync();
  })
  .then(() => {
    console.log('All models synced');
  })
  .catch((err) => {
    console.error('Unable to connect to the database:', err);
  });

// 挂载路由
app.use('/api', routes);

// 测试用根路由
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(PORT, () => {
  console.log(`Server listening on http://localhost:${PORT}`);
});
