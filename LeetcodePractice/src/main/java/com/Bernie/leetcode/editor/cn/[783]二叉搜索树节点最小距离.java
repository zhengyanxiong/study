 //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 143 👎 0

  
package com.Bernie.leetcode.editor.cn;

 import java.util.Deque;
 import java.util.LinkedList;

 class MinimumDistanceBetweenBstNodes{
    public static void main(String[] args) {
         Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  class TreeNode {
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
    private int ans;
    private int pre;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return;
        while (null != root || !stack.isEmpty()) {
            while (root !=null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();

            if (pre == -1) {
                pre = node.val;
            } else {
                ans = Math.min(ans, node.val - pre);
                pre = node.val;
            }

            stack.pop();

            root = root.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }