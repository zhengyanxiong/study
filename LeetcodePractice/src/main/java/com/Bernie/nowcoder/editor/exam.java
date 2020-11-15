package com.Bernie.nowcoder.editor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/10 21:31
 */
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            int m = sc.nextInt();
            int ans = 0, sum=0;
            String[] strings = s.split(",");
            for (int i=0;i<strings.length;i++) {
                for (int j = i +1 ; j<strings.length;j++) {
                    if (Integer.parseInt(strings[i]) > Integer.parseInt(strings[j])) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
            for (String s1 : strings) {
                sum += Integer.parseInt(s1);
                if (sum <= m) {
                    ans++;
                };
            }
            System.out.println(ans);
        }
    }
}

class Main2{
    public static void main(String[] args) {
        int n = 16;
        int i =0;
        long sum = 1;
        while (i<n) {
            sum = sum * 2;
            i++;
        }
        System.out.println(sum);
    }
}