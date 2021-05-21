package com.Bernie.Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Bernie
 * @date 2021/03/13 10:59:14
 **/
public class MyHashSet {
    private static final int BASE = 11;
    private LinkedList[] data;

    /**
     *
     * @author Bernie
     * @date 2021/03/13 11:16:18
     * @return
     **/
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    /**
     * 向HaseSet中添加元素
     * @author Bernie
     * @date 2021/03/13 11:29:03
     * @param value
     * @return
     **/
    public void add(int value) {
        int key = hash(value);
        Iterator<Integer> integerIterator = data[key].iterator();
        while (integerIterator.hasNext()) {
            Integer element = integerIterator.next();
            if (value == element) {
                return;
            }
        }

        data[key].addLast(value);
    }

    /**
     * 删除MyHashSet中的元素
     * @author Bernie
     * @date 2021/03/13 11:31:52
     * @param value 目标值
     * @return void
     **/
    public void remove(int value) {
        int key = hash(value);
        Iterator<Integer> integerIterator = data[key].iterator();
        while (integerIterator.hasNext()) {
            Integer element = integerIterator.next();
            if (element == value) {
                data[key].remove(element);
                return;
            }
        }
    }

    /**
     * Determine whether the MyHashSet contains value
     * @author Bernie
     * @date 2021/03/13 11:39:56
     * @param value 目标值
     * @return true | false
     **/
    public boolean contains(int value) {
        int key = hash(value);
        Iterator<Integer> integerIterator = data[key].iterator();
        while (integerIterator.hasNext()) {
            Integer element = integerIterator.next();
            if (element == value) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @author Bernie
     * @date 2021/03/13 11:20:30
     * @param key
     * @return
     **/
    private static int hash(int key) {
        return key % BASE;
    }

    public void printValue() {
        Arrays.stream(data).forEach(System.out::print);
    }


    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
        myHashSet.printValue();
    }
}
