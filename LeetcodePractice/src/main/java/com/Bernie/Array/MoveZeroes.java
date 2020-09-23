package com.Bernie.Array;

/**
 * @author Bernie
 * @Date 2019/1/10 14:47
 **/
public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                } else {
                    j++;
                }

            }
            System.out.println("i:"+i+" <----------> j: "+j);
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0};
        new MoveZeroes().moveZeroes(nums);
    }
}
