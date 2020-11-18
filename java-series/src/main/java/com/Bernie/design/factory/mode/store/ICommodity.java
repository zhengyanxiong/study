package com.Bernie.design.factory.mode.store;

import java.util.Map;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 16:30
 */
public interface ICommodity {
    //接⼝的⼊参包括； ⽤户ID 、 奖品ID 、 业务ID 以及 扩展字段 ⽤于处理发放实物商品时的收获地址
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
