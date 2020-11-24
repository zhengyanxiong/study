package com.Bernie.design.factory.build.matter.coat;

import com.Bernie.design.factory.build.matter.Matter;

import java.math.BigDecimal;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 21:57
 */
public class DuluxCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士（Dulux）";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(345);
    }

    @Override
    public String desc() {
        return "多乐士涂料";
    }
}
