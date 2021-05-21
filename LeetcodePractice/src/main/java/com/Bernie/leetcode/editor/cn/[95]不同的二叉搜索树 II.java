 //给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 851 👎 0

  
package com.Bernie.leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 class UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
         Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) return ans;
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = getAns(start, i - 1);
            List<TreeNode> right = getAns(i + 1, end);

            for (TreeNode leftTreeNode : left) {
                for (TreeNode rightTreeNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTreeNode;
                    treeNode.right = rightTreeNode;
                    ans.add(treeNode);
                }
            }
            
        }


        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  }