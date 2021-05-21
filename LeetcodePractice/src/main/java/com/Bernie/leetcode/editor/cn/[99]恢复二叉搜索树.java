//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 454 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
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

        public void recoverTree1(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null, x = null, y = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.peek();
                // 处理当前节点
                if (pre != null && root.val < pre.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    } else {
                        break;
                    }
                }

                stack.pop();
                pre = root;
                root = root.right;
            }
            // 交换找出的节点x, y
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }

        private TreeNode first = null, second = null, pre = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {

            // 使用dfs获取first和second;
            dfs(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;

        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);

            if (first == null && root.val < pre.val) first = pre;
            if (first != null && root.val < pre.val) second = root;

            pre = root;

            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}