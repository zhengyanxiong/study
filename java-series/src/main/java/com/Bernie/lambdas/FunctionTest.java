package com.Bernie.lambdas;

import java.util.function.Function;

/**
 * @author Bernie
 * @Date 2021/05/29 23:03
 * 请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "赵丽颖,20";
 * 1. 将字符串截取数字年龄部分，得到字符串；
 * 2. 将上一步的字符串转换成为int类型的数字；
 * 3. 将上一步的int数字累加100，得到结果int数字。
 */
public class FunctionTest {
    private static final String STR = "赵丽颖,20";

    private static void solution(Function<String, String> o1, Function<String,Integer> o2,
                                 Function<Integer,Integer> o3) {
        Integer apply = o1.andThen(o2).andThen(o3).apply(STR);
        System.out.println("结果："+ apply);
    }

    public static void main(String[] args) {
        solution(s -> s.split("\\,")[1],
                s -> Integer.parseInt(s),
                s -> s += 100);
    }
}
