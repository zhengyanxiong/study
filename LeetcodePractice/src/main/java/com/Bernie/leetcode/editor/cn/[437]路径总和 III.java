//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 844 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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
        Map<Integer, Integer> prefixMap;
        int target;
        public int pathSum(TreeNode root, int targetSum) {
            prefixMap = new HashMap<>();
            target = targetSum;
            // 前缀和为0的一条路径
            prefixMap.put(0, 1);
            return recur(root, 0);
        }

        private int recur(TreeNode root, int curSum) {
            if (root == null) return 0;
            //处理当前层的和
            int res = 0;
            curSum += root.val;

            // 满足目标路径的条数
            res += prefixMap.getOrDefault(curSum - target, 0);
            // 更新当前路径上节点的前缀和个数
            prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

            // 进入下一层
            res += recur(root.left, curSum);
            res += recur(root.right, curSum);

            //回溯恢复状态
            prefixMap.put(curSum, prefixMap.get(curSum) -1);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}