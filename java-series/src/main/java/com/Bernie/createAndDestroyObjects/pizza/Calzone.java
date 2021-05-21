package com.Bernie.createAndDestroyObjects.pizza;


/**
 * @author Bernie
 * @Date 2021/05/13 16:05
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside () {
            this.sauceInside = true;
            return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "Toppings=" + toppings.toString() +
                ",sauceInside=" + sauceInside +
                '}';
    }

    public static void main(String[] args) {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Topping.HAM)
                .addTopping(Topping.MUSHROOM)
                .sauceInside().build();
        System.out.println(calzone.toString());
    }
}
