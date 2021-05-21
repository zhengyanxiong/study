//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 306 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
        List<Integer> ans = new ArrayList<>();
        int base , count, maxCount;
        public int[] findMode(TreeNode root) {
            dfs(root);
            return ans.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            unpdate(node.val);
            dfs(node.right);
        }

        private void unpdate(int val) {
            if (val == base) {
                count++;
            }else {
                count = 1;
                base = val;
            }

            if (count == maxCount) {
                ans.add(val);
            }
            if (count > maxCount) {
                maxCount = count;
                ans.clear();
                ans.add(val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}