package com.Bernie.design.factory.build.matter.tile;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class MarcoPloloTtle implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "马克菠萝";
    }

    @Override
    public String model() {
        return "缺省";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(141);
    }

    @Override
    public String desc() {
        return "马可波罗，最早品牌化的建陶品牌。";
    }
}
