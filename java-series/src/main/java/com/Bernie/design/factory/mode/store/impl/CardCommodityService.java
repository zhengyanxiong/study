package com.Bernie.design.factory.mode.store.impl;

import com.Bernie.design.factory.mode.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Map;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 16:31
 * 第三房兑换卡
 */
public class CardCommodityService implements ICommodity {
    private static final Logger log = LoggerFactory.getLogger(CardCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        log.info("第三方兑换卡奖品发放开始");
        log.info("用户[{}]兑换卡发放成功,{},{}",uId,commodityId,bizId);
    }
}
