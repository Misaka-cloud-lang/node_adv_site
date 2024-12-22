// controllers/adAnalysisController.js
const express = require('express');
const router = express.Router();

const { getPerformanceData } = require('../services/adAnalysisService');

/**
 * GET /analysis/performance
 * 参数示例: 
 *   /analysis/performance?adId=1&startTime=2024-12-01&endTime=2024-12-31
 */
router.get('/performance', async (req, res) => {
  try {
    const { adId, startTime, endTime } = req.query;
    const start = startTime ? new Date(startTime) : null;
    const end = endTime ? new Date(endTime) : null;

    const data = await getPerformanceData(adId, start, end);
    return res.json({ success: true, data });
  } catch (error) {
    console.error('Error in performance:', error);
    return res.status(500).json({ success: false, message: error.message });
  }
});

module.exports = router;
