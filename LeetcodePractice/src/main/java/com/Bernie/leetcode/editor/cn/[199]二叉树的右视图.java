//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 453 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.*;

class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            dfs(root, 0, res);

            /*Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int i=0; i< queueSize; i++) {
                    TreeNode curr = queue.poll();
                    if (i == queueSize - 1) {
                        res.add(curr.val);
                    }
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }

            }*/

            return res;
        }

        private void dfs(TreeNode node, int depth, List<Integer> res) {
            if (node == null) return;
            if (depth == res.size()) {
                res.add(node.val);
            }
            depth++;
            dfs(node.right, depth, res);
            dfs(node.left, depth, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}