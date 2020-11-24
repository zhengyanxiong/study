package com.Bernie.design.factory.build;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 22:33
 */
public enum DecorationGrade {
    LUXURY_EUROPEAN_STYLE("豪华欧式"),
    LIGHT_LUXURY_PASTORAL("轻奢田园"),
    MODERN_SIMPLICITY("现代简约");

    public final String grade;

    DecorationGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.grade;
    }
}
