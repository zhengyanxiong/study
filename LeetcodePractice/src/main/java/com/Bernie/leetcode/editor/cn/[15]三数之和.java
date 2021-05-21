package com.Bernie.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3070 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) return result;

        Arrays.sort(nums);

        for (int first = 0; first < length; ++first) {
            if (first > 0 && nums[first] == nums[first -1]) {
                continue;
            }
            int third = length -1;
            int target = -nums[first];
            for (int second = first + 1; second < length; ++second) {
                if (second > first + 1 && nums[second] == nums[second -1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[first], nums[second], nums[third])));
                }
            }
        }


        return result;
    }

    private boolean checkSum(int a, int b, int c) {
        return a + b + c == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[] {-1, 0, 1,2,-1,-4};
        System.out.println(solution.threeSum(num));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
