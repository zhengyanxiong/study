package com.Bernie.Array;

/**
 * @author Bernie
 * @Date 2019/1/10 11:28
 **/
public class SingleNumber {
    public int singleNumber(int[] nums){
        int num=0;
        for(int i=0;i<nums.length;i++){
            num ^= nums[i];
            System.out.println("i:"+i+"---->num:"+num+"----->nums:"+nums[i]);
        }

        return num;
    }

    public static void main(String[] args){
        int nums[] = {1,10,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));
    }
}
