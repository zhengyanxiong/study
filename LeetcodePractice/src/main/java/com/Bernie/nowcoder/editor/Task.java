package com.Bernie.nowcoder.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/16 22:17
 */
public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] taskArray = s.split(",");
            int[] tasks = new int[taskArray.length];
            for (int i=0;i<taskArray.length;i++) {
                tasks[i] = Integer.parseInt(taskArray[i]);
            }

            int sleepNum = sc.nextInt();


            System.out.println(performTask(tasks,sleepNum));
        }
    }

    private static int performTask(int[] taskArrays, int n) {
        if (n == 0) return taskArrays.length;

        Arrays.sort(taskArrays);

        for (int i=0;n>0;i++) {

        }
        return 0;
    }
}
