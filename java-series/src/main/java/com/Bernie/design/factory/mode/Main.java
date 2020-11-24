package com.Bernie.design.factory.mode;

import com.Bernie.design.factory.mode.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:05
 */
public class Main {
    Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        ICommodity iCommodity = StoreFactory.getCommodityService(CommodityEnum.GOODS_COMMODITY);
        iCommodity.sendCommodity("002","11039","888",null);
    }
}
