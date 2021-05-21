//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 342 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int length = nums.length;
            if (length < 3) return false;

            // 通过单调栈存放满足3的元素
            Deque<Integer> stack = new LinkedList<>();
            stack.push(nums[length - 1]);
            // 定义满足2的元素变量
            int maxK = Integer.MIN_VALUE;

            for (int i = length - 2; i >= 0 ; i--) {
                if (nums[i] < maxK) {
                    return true;
                }
                // 当前元素大于3的元素，则不满足2<3条件，出栈，出栈的元素一定是满足2的条件
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    maxK = stack.pop();
                }
                // 当前元素大于k值，满足成为3的，入栈
                if (nums[i] > maxK) {
                    stack.push(nums[i]);
                }
            }


            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}