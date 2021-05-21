//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 574 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            //dfs(root, res);
            bfs(root, res);
            return res;
        }

        private void bfs(TreeNode node, List<Integer> res) {
            if (node == null) return;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode preNode = null;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.poll();
                if (node.right == null || node.right == preNode) {
                    res.add(node.val);
                    preNode = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }

        private void dfs(TreeNode node, List<Integer> res) {
            if (node == null) return;
            dfs(node.left, res);
            dfs(node.right, res);
            res.add(node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}