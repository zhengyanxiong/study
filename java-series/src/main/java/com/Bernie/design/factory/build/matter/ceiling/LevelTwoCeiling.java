package com.Bernie.design.factory.build.matter.ceiling;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class LevelTwoCeiling implements Matter {
    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm";
    }
}
