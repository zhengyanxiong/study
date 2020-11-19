package com.Bernie.design.factory.mode.store.impl;

import com.Bernie.design.factory.mode.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 16:32
 * 优惠券商品兑换
 */
public class CouponCommodityService implements ICommodity {
    private static final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        logger.info("优惠商品兑换发放开始");
        logger.info("用户[{}]优惠商品兑换发放成功,{},{}",uId,commodityId,bizId);
    }
}
