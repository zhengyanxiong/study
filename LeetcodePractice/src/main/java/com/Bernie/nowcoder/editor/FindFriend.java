package com.Bernie.nowcoder.editor;

import java.util.Scanner;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/16 21:15
 */
public class FindFriend {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            int[] height = new int[n], ans = new int[n];
            for (int i=0;i<n;i++){
                height[i] = sc.nextInt();
            }
            for (int i=0;i<height.length;i++) {
                for (int j= i+1;j<height.length;j++) {
                    if (height[i] < height[j]) {
                        ans[i] = j;
                        break;
                    } else {
                        ans[i] = 0;
                    }
                }
            }
            for (int i:ans) {
                System.out.print(i + " ");
            }
        }
    }
}
