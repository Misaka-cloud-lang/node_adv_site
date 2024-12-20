package org.example.advertisement_system.entity;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 网店网站用户画像类，继承自抽象用户画像类，包含网店网站特有的用户画像信息。
 */
public class StoreUserProfile extends AbstractUserProfile {
    /**
     * 购物车项列表。
     */
    private List<CartItem> cartItems;

    /**
     * 购买记录列表。
     */
    private List<PurchaseRecord> purchaseHistory;

    // Getters and Setters

    /**
     * 获取购物车项列表。
     *
     * @return 购物车项列表。
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * 设置购物车项列表。
     *
     * @param cartItems 购物车项列表。
     */
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * 获取购买记录列表。
     *
     * @return 购买记录列表。
     */
    public List<PurchaseRecord> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * 设置购买记录列表。
     *
     * @param purchaseHistory 购买记录列表。
     */
    public void setPurchaseHistory(List<PurchaseRecord> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    /**
     * 更新商品标签的权重。
     *
     * @param tag 商品标签。
     * @param interactionType 交互类型（浏览、加入购物车、购买）。
     */
    public void updateProductTagWeight(String tag, InteractionType interactionType) {
        int weightIncrement;
        switch (interactionType) {
            case VIEW:
                weightIncrement = 1; // 浏览商品，权重加1
                break;
            case CART:
                weightIncrement = 2; // 加入购物车，权重加2
                break;
            case PURCHASE:
                weightIncrement = 3; // 购买商品，权重加3
                break;
            default:
                weightIncrement = 0;
        }
        super.updateTagWeight(tag, weightIncrement);
    }
}

/**
 * 交互类型枚举类，表示用户与商品之间的交互类型。
 */
enum InteractionType {
    /**
     * 浏览商品。
     */
    VIEW,

    /**
     * 加入购物车。
     */
    CART,

    /**
     * 购买商品。
     */
    PURCHASE
}

/**
 * 购物车项类，记录用户加入购物车的商品信息。
 */
class CartItem {
    /**
     * 商品唯一标识符。
     */
    private String productId;

    /**
     * 商品加入购物车的时间戳。
     */
    private LocalDateTime addedTime;

    // Getters and Setters

    /**
     * 获取商品唯一标识符。
     *
     * @return 商品唯一标识符。
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置商品唯一标识符。
     *
     * @param productId 商品唯一标识符。
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取商品加入购物车的时间戳。
     *
     * @return 商品加入购物车的时间戳。
     */
    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    /**
     * 设置商品加入购物车的时间戳。
     *
     * @param addedTime 商品加入购物车的时间戳。
     */
    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }
}

/**
 * 购买记录类，记录用户购买的商品信息。
 */
class PurchaseRecord {
    /**
     * 商品唯一标识符。
     */
    private String productId;

    /**
     * 商品购买的时间戳。
     */
    private LocalDateTime timestamp;

    // Getters and Setters

    /**
     * 获取商品唯一标识符。
     *
     * @return 商品唯一标识符。
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置商品唯一标识符。
     *
     * @param productId 商品唯一标识符。
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取商品购买的时间戳。
     *
     * @return 商品购买的时间戳。
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 设置商品购买的时间戳。
     *
     * @param timestamp 商品购买的时间戳。
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
