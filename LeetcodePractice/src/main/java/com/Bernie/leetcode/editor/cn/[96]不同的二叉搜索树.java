//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1121 👎 0


package com.Bernie.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public class TreeNode {
            int val;
            Solution.TreeNode left;
            Solution.TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        // G(n) = f(1) + f(2) + f(3) + ...... + f(4)
        // f(i) = G(i-1) * G(n - i)
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n ; i++) {
                for (int j = 1; j <= i ; j++) {
                    dp[i] += dp[j - 1] * dp[i -j];
                }
            }



            return dp[n];
        }

        private List<TreeNode> getKind(int start, int end) {
            List<TreeNode> ans = new ArrayList<>();
            if (start > end) {
                ans.add(null);
                return ans;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTree = getKind(start, i - 1);
                List<TreeNode> rightTree = getKind(i + 1, end);

                for (TreeNode left : leftTree) {
                    for (TreeNode right: rightTree) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = left;
                        curr.right = right;
                        ans.add(curr);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}