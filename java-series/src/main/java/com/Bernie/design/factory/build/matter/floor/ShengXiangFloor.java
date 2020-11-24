package com.Bernie.design.factory.build.matter.floor;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class ShengXiangFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣像";
    }

    @Override
    public String model() {
        return "一级";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(318);
    }

    @Override
    public String desc() {
        return "圣象地板是中国地板行业著名商标";
    }
}
