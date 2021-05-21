package com.Bernie.createAndDestroyObjects;

/**
 * @author Bernie
 * @Date 2021/05/13 15:29
 * 营养成分类通过建造者模式来构建对象
 */
public class NutritionFacts {
    private final int servingSize;  // 份量
    private final int servings;     // 份
    private final int calories;     // 卡路里
    private final int fat;          // 脂肪
    private final int sodium;       // 纳
    private final int carbohydrate; // 糖

    public static class Builder {
        // 必须的两个参数
        private final int servingSize;
        private final int servings;

        private int calories        = 0;
        private int fat             = 0;
        private int sodium          = 0;
        private int carbohydrate    = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        this.servingSize  = builder.servingSize;
        this.servings     = builder.servings;
        this.calories     = builder.calories;
        this.fat          = builder.fat;
        this.sodium       = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new Builder(240, 8)
                .calories(3)
                .carbohydrate(20)
                .sodium(23)
                .build();

        System.out.println(nutritionFacts.toString());
    }
}
