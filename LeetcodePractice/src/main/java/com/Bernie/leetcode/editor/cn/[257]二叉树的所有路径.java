//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 493 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> path = new ArrayList<>();
            //dfs(root, "", path);
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<String> pathQueue = new LinkedList<>();
            queue.offer(root);
            pathQueue.offer(Integer.toString(root.val));

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                String currPath = pathQueue.poll();

                if (curr.left == null && curr.right == null) {
                    // 叶子节点
                    path.add(currPath);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                    pathQueue.add(new StringBuilder(currPath).append("->").append(curr.left.val).toString());
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    pathQueue.add(new StringBuilder(currPath).append("->").append(curr.right.val).toString());
                }
            }

            return path;
        }

        private void dfs(TreeNode root, String path, List<String> pathList) {
            if (root == null) return;
            StringBuilder pathBuilder = new StringBuilder(path);
            pathBuilder.append(root.val);
            if (root.left == null && root.right == null) {
                // 叶子节点
                pathList.add(pathBuilder.toString());
            } else {
                pathBuilder.append("->");
                dfs(root.left, pathBuilder.toString(), pathList);
                dfs(root.right, pathBuilder.toString(),pathList);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}