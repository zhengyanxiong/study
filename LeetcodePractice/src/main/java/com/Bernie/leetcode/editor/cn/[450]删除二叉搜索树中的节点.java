//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 445 👎 0


package com.Bernie.leetcode.editor.cn;

import java.time.temporal.Temporal;

class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        TreeNode root = new DeleteNodeInABst().new TreeNode(5);
        solution.buildTree(new String[] {"5","3","6","2","4",null,"7"}, root);
        System.out.println(solution.dfs(root,new StringBuilder()));
        solution.deleteNode(root, 3);
        System.out.println(solution.dfs(root,new StringBuilder()));
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            // delete from the right subtree
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                // delete from the left subtree
                root.right = deleteNode(root.right, key);
            } else {
                // delete the current node
                if (root.left == null) return root.right;
                // the node is not a leaf and has a right child
                if (root.right == null) return root.left;
                //
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
            }
            return root;
        }

        private void buildTree(String[] array, TreeNode node){
            node.left = new TreeNode(3,new TreeNode(2),new TreeNode(4));
            node.right = new TreeNode(6,null,new TreeNode(7));
        }

        private StringBuilder dfs(TreeNode node, StringBuilder stringBuilder) {
            if (node == null) return null;
            dfs(node.left, stringBuilder);
            stringBuilder.append(node.val).append(",");
            dfs(node.right, stringBuilder);
            return stringBuilder;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}