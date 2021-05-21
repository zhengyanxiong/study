package com.Bernie.createAndDestroyObjects.pizza;

import java.util.Objects;

/**
 * @author Bernie
 * @Date 2021/05/13 16:00
 */
public class NyPizza extends Pizza{
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(Size.MEDIUM).addTopping(Topping.MUSHROOM).build();
        System.out.println(nyPizza.toString());
    }
}
