// public/script.js

async function fetchAd() {
    try {
      const response = await fetch('/api/render/getAd?userId=U001&siteType=news');
      const data = await response.json();
  
      if (data.success) {
        const ad = data;
        const adIframe = document.getElementById('ad-iframe');
  
        // 传递广告数据给 iframe
        adIframe.contentWindow.adData = ad;
        adIframe.src = 'ad.html'; // 加载广告展示页面
  
        // 记录曝光（可选，如果广告页面内部已经记录，可以省略）
        // await trackImpression(ad.adId);
      } else {
        console.log(data.message);
        displayNoAdMessage('ad-container', data.message);
      }
    } catch (error) {
      console.error('Error fetching ad:', error);
    }
  }
  
  async function trackImpression(adId) {
    try {
      await fetch('/api/render/trackImpression', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ adId: adId, userId: 'U001', siteType: 'news' })
      });
    } catch (error) {
      console.error('Error tracking impression:', error);
    }
  }
  
  async function trackClick(adId) {
    try {
      await fetch('/api/render/trackClick', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ adId: adId, userId: 'U001', siteType: 'news' })
      });
    } catch (error) {
      console.error('Error tracking click:', error);
    }
  }
  
  function displayNoAdMessage(containerId, message) {
    const adContainer = document.getElementById(containerId);
    const messageElement = document.createElement('p');
    messageElement.textContent = message;
    adContainer.appendChild(messageElement);
  }
  
  // 监听来自 iframe 的消息
  window.addEventListener('message', (event) => {
    if (event.data.type === 'adImpression') {
      trackImpression(event.data.adId);
    } else if (event.data.type === 'adClick') {
      trackClick(event.data.adId);
    }
  });
  
  // 页面加载时获取广告
  window.onload = fetchAd;
  