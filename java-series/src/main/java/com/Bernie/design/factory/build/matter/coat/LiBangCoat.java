package com.Bernie.design.factory.build.matter.coat;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class LiBangCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "立邦";
    }

    @Override
    public String model() {
        return "默认级别";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "立邦涂料";
    }
}
