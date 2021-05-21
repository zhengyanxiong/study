//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 999 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //记录前序遍历和中序遍历的长度
            int preLen = preorder.length, inLen = inorder.length;
            //使用Hash表定位根节点
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inLen; i++) {
                map.put(inorder[i], i);
            }
            // 递归构造二叉树
            return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
        }

        private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
            // 终止条件
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }

            int rootValue = preorder[preLeft];
            TreeNode root = new TreeNode(rootValue);
            int pIndex = map.get(rootValue);

            root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
            root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}