package com.Bernie.lambdas;

import java.util.function.Predicate;

/**
 * @author Bernie
 * @Date 2021/05/29 22:20
 * predicate 函数接口测试
 */
public class PredicateTest {
    private static final String STRING = "OOM SOF";
    /**
     * 判断字符串是否存在字母O
     * @param predicate
     */
    private static void test(Predicate<String> predicate) {
        System.out.println(predicate.test(STRING));
    }

    /**
     * 判断字符串是否同时存在O, H
     * @param predicate1
     * @param predicate2
     */
    private static void and(Predicate<String> predicate1, Predicate<String> predicate2) {
        System.out.println(predicate1.and(predicate2).test(STRING));
    }

    /**
     * 判断字符串是否一方存在 O , H
     * @param predicate1
     * @param predicate2
     */
    private static void or(Predicate<String> predicate1, Predicate<String> predicate2) {
        System.out.println(predicate1.or(predicate2).test(STRING));
    }


    public static void main(String[] args) {
        test(s -> s.contains("O"));
        and(s -> s.contains("O"), s -> s.contains("F"));
        or(s -> s.contains("O"), s -> s.contains("H"));
    }
}
