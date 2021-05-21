//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 249 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null) return res;
            Arrays.sort(nums);
            int length = nums.length;
            int[] dp = new int[length];
            Arrays.fill(dp,1);
            int maxSize = 1;
            int maxValue = dp[0];

            // 动态规划找出最大子集个数和最大最大子集值
            for (int i = 1; i< length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i]>maxSize) {
                    maxSize = dp[i];
                    maxValue = nums[i];
                }
            }

            // 倒推获得最大子集
            if (maxSize == 1) {
                res.add(nums[0]);
                return res;
            }

            for (int i = length - 1; i >=0 ; i--) {
                if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                    res.add(nums[i]);
                    maxSize--;
                    maxValue = nums[i];
                }
            }




            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}