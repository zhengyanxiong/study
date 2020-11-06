package com.Bernie.Interview;

import java.util.Scanner;

/**
 * @CssName DetermineWhetherTheStringIsUnique
 * @Description TODO
 * @Author bernie
 * @Date 2020/9/22 下午9:05
 **/
public class DetermineWhetherTheStringIsUnique {

    public boolean isUnique(String astr) {
        long low64 = 0,height64=0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long index = 1L << (c - 64);
                if ((height64 & index) != 0) return false;
                height64 |= index;
            } else {
                long index = 1L << c;
                if ((low64 & index) != 0) return false;
                low64 |= index;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int emptyBottleNum = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================");
        while(emptyBottleNum != 0) {
            System.out.print("请输入空瓶子数：");
            emptyBottleNum = sc.nextInt();
            if(emptyBottleNum == 0) break;
            System.out.println("最多得到的汽水：" + getBottle(emptyBottleNum));
            System.out.println("=====================");
        }

    }

    public static int getBottle(int emptyBottleNum) {
        int bootleCount = 0;
        if(emptyBottleNum == 2) bootleCount = 1;
        while( (emptyBottleNum + 1) > 3) {
            int temZ = emptyBottleNum / 3;
            int temY = emptyBottleNum % 3;
            emptyBottleNum = temZ + temY;
            bootleCount += temZ;
            if(emptyBottleNum + 1 == 3) {
                bootleCount++;
                break;
            }
        }

        return bootleCount;
    }
}