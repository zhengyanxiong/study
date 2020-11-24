package com.Bernie.design.factory.build.matter.floor;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class DerFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔（Der）";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "DER德尔集团是全球领先的专业木板制造商。";
    }
}
