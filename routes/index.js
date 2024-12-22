// routes/index.js
const express = require('express');
const router = express.Router();

const adAnalysisController = require('../controllers/adAnalysisController');
const adRenderingController = require('../controllers/adRenderingController');

// 广告分析接口
router.use('/analysis', adAnalysisController);
// 广告渲染接口
router.use('/render', adRenderingController);

module.exports = router;
