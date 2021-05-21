//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 491 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int inLength = inorder.length;
            int postLength = postorder.length;
            // 使用Hash表定位根节点
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inLength; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(postorder, 0, inLength - 1, map, 0, postLength - 1);
        }

        private TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map, int inLeft, int inRight) {
            if (inLeft > inRight || postLeft > postRight) {
                return null;
            }
            int rootValue = postorder[postRight];
            TreeNode root = new TreeNode(rootValue);
            int pIndex = map.get(rootValue);
            root.left = buildTree(postorder, postLeft, pIndex - 1 - inLeft + postLeft, map,inLeft,pIndex -1);
            root.right = buildTree(postorder,pIndex-inLeft+postLeft,postRight -1,map,pIndex + 1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}