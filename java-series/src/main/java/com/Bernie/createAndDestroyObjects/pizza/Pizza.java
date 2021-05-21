package com.Bernie.createAndDestroyObjects.pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Bernie
 * @Date 2021/05/13 15:49
 * Pizza类根部有一个抽象类表示各式各样的披萨
 */
public class Pizza {
    public enum Topping {
        HAM,      // 火腿
        MUSHROOM, // 蘑菇
        ONION,    // 洋葱
        PEPPER,   // 胡椒
        SAUSAGE   // 香肠
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

}
