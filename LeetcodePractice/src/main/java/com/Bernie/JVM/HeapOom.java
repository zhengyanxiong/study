package com.Bernie.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * create by: Bernie
 * description: 测试堆的OOM
 * create time: 2020/10/12 22:29
 */
public class HeapOom {
    byte[] bytes = new byte[1024 * 100];
    public static void main(String[] args) throws InterruptedException{
        List<HeapOom> heapOomList = new ArrayList<HeapOom>();
        while (true) {
            heapOomList.add(new HeapOom());
            Thread.sleep(10);
        }
    }
}
