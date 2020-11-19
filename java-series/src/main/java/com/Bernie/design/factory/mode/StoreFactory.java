package com.Bernie.design.factory.mode;

import com.Bernie.design.factory.mode.store.ICommodity;
import com.Bernie.design.factory.mode.store.impl.CardCommodityService;
import com.Bernie.design.factory.mode.store.impl.CouponCommodityService;
import com.Bernie.design.factory.mode.store.impl.GoodsCommodityService;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 16:39
 */
public class StoreFactory {
    public static ICommodity getCommodityService(CommodityEnum commodityEnum) {
        if (null == commodityEnum) return null;
        if (CommodityEnum.COUPON_COMMODITY == commodityEnum) return new CouponCommodityService();
        if (CommodityEnum.GOODS_COMMODITY == commodityEnum) return new GoodsCommodityService();
        if (CommodityEnum.CARD_COMMODITY == commodityEnum) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
