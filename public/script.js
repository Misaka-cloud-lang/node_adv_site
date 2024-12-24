// public/script.js
async function fetchAd() {
    try {
      const response = await fetch('/api/render/getAd?userId=U001&siteType=news');
      const data = await response.json();
  
      if (data.success) {
        const ad = data;
        const adContainer = document.getElementById('ad-container');
        
        // 创建广告元素
        const adElement = document.createElement('div');
        adElement.classList.add('ad');
        adElement.innerHTML = `
          <h2 class="ad-title">${ad.title}</h2>
          <img src="${ad.imageUrl}" alt="${ad.title}">
          <p class="ad-description">${ad.description}</p>
          <a href="${ad.targetUrl}" target="_blank" class="ad-button" onclick="trackClick(${ad.adId})">点击查看</a>
        `;
        
        adContainer.appendChild(adElement);
  
        // 记录曝光
        trackImpression(ad.adId);
      } else {
        console.log(data.message);
        displayNoAdMessage(data.message);
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
  
  function displayNoAdMessage(message) {
    const adContainer = document.getElementById('ad-container');
    const messageElement = document.createElement('p');
    messageElement.textContent = message;
    adContainer.appendChild(messageElement);
  }
  
  // 页面加载时获取广告
  window.onload = fetchAd;
  