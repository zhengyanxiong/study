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
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
