//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 556 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res;
        private List<Integer> path;

        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            backTracking(n, k, 1);
            return res;
        }

        private void backTracking(int n, int k, int startIndex) {
            // 终止条件
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i<=n - (k - path.size()) + 1; i++) {
                path.add(i);
                //递归子树
                backTracking(n, k, i+1);
                // 回溯
                path.remove(path.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}