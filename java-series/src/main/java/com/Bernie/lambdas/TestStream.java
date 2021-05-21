package com.Bernie.lambdas;

import java.util.stream.Stream;

/**
 * @author Bernie
 * @Date 2021/04/13 15:22
 */
public class TestStream {
    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc,x) -> acc + x);
    }


    public static void main(String[] args) {
        TestStream test = new TestStream();
        System.out.println(test.addUp(Stream.of(1,2,3)));
    }
}
