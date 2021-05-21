//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 494 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.*/
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
      }
      }

    class Solution {
        class QueueNode{
            TreeNode node;
            int depth;
            QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
        public int minDepth(TreeNode root) {
            //dfs
            if (root == null) return 0;
            /*int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0) return right + 1;
            if (right == 0) return left + 1;
            return Math.min(left, right) + 1;*/

            // bfs
            // 广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
            Queue<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root,1));
            while (!queue.isEmpty()) {
                QueueNode queueNode = queue.poll();
                TreeNode treeNode = queueNode.node;
                int depth = queueNode.depth;
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
                if (treeNode.left != null) {
                    queue.offer(new QueueNode(treeNode.left, depth + 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new QueueNode(treeNode.right, depth + 1));
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}