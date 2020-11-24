package com.Bernie.design.factory.build.matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:42
 * 物料接口
 */
public interface Matter {
    String scene();      // 场景：地板，地砖，涂料，吊顶
    String brand();      // 品牌
    String model();      // 型号
    BigDecimal price();  // 价格
    String desc();       // 描述

}
