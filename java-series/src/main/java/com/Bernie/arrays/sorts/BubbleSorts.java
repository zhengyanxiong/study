package com.Bernie.arrays.sorts;

/**
 * create by: Bernie
 * description: 数组冒泡排序
 * create time: 2020/10/25 15:18
 */
public class BubbleSorts {
    public static int[] sorts(int[] array) {
        for (int i=1 ;i< array.length;i++) {
            boolean flag = true;
            for (int j=0; j< array.length - i; j ++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            System.out.print("第["+i+"]次排序：");
            show(array);
            if (flag) break;
        }
        return array;
    }

    public static void show(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numberArray = {6,4,3,8,1,2,0};
        long startTime = System.currentTimeMillis();
        System.out.print("排序前：");
        show(numberArray);
        System.out.println("-------------------------------");
        numberArray = sorts(numberArray);
        System.out.print("排序后：");
        show(numberArray);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------------------");
        System.out.println("耗时：" + (endTime - startTime));
    }
}
