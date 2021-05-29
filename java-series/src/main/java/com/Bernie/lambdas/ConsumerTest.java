package com.Bernie.lambdas;

import java.util.function.Consumer;

/**
 * @author Bernie
 * @Date 2021/05/29 23:16
 *  请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来
 */
public class ConsumerTest {
    public static void formatPersonMsg(Consumer<String[]> con1, Consumer<String[]> con2) {
        con1.andThen(con2).accept(new String[] { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" });
    }

    public static void main(String[] args) {
        formatPersonMsg(strings -> {
            for (String str : strings) {
                System.out.print(str.split("\\,")[0] + " ");
            }
        }, strings -> {
            System.out.println();
            for (String str : strings) {
                System.out.print(str.split("\\,")[1] + " ");
            }
        });
    }
}
