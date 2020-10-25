package com.Bernie.arrays.sorts;

/**
 * create by: Bernie
 * description: 数组选择排序
 * create time: 2020/10/25 15:41
 */
public class ChoiceSorts {
    public static int[] sorts(int[] array) {
        for (int i=0 ;i< array.length -1;i++) {
            int min = i;
            for (int j= i+1;j<array.length;j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            System.out.print("第["+i+"]次排序：");
            show(array);

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
