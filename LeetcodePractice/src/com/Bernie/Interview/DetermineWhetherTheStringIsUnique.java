package com.Bernie.Interview;

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

    public static void main(String args[]) {
        String s = "abbc";
        System.out.println(new DetermineWhetherTheStringIsUnique().isUnique(s));
    }
}