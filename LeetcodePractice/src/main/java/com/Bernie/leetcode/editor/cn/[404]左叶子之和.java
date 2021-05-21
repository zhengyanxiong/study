//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 311 👎 0


package com.Bernie.leetcode.editor.cn;

class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;
            if (root == null) return 0;
            if (root.left != null) {
                sum += isChildNode(root.left) ? root.left.val : sumOfLeftLeaves(root.left) ;
            }
            if (root.right != null && !isChildNode(root.right)) {
                sum += sumOfLeftLeaves(root.right);
            }
            return sum;
        }

        boolean isChildNode(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}