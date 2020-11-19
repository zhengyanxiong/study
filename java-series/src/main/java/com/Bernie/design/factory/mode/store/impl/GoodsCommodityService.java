package com.Bernie.design.factory.mode.store.impl;

import com.Bernie.design.factory.mode.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 16:32
 * 实物商品兑换
 */
public class GoodsCommodityService implements ICommodity {
    private static final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        logger.info("实物商品兑换发放开始");
        logger.info("用户[{}]实物商品兑换发放成功,{},{}",uId,commodityId,bizId);
    }
}
