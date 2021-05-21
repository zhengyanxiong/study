//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 515 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1,2,2});
        System.out.println(solution.res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            dfs(nums, 0, used);

            return res;
        }

        private void dfs(int[] nums, int startIndex, boolean[] used) {
            res.add(new ArrayList<>(path));
            for (int i = startIndex; i < nums.length; i++) {
                if (i> 0 &&nums[i] == nums[i-1] && used[i-1] == false) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, i+1, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}