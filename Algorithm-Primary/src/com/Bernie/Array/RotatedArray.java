package com.Bernie.Array;

/**
 * @author Bernie
 * @Date 2019/1/9 18:47
 **/
public class RotatedArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for(int j = 0;j<k;j++){
            int temp = nums[n - 1];
            for(int i=n-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }

        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }

    public static void main(String[] args){
        int[] arrays = {1,2,3,4,5,6,7};
        int k = 3;
        new RotatedArray().rotate(arrays,k);
    }
}
