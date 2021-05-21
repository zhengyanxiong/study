//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 104] 
// 0 <= Node.val <= 104 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 184 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBst().new Codec();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.*/
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = infixDfs(root, new StringBuilder());
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() -1);
            }

            return stringBuilder.toString();
        }

        private StringBuilder infixDfs(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) return stringBuilder;
            stringBuilder.append(root.val)
                    .append(' ');
            infixDfs(root.left, stringBuilder);
            infixDfs(root.right, stringBuilder);
            return stringBuilder;
        }

        private StringBuilder postDfs(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) return stringBuilder;
            postDfs(root.left, stringBuilder);
            postDfs(root.right, stringBuilder);
            stringBuilder.append(root.val)
                    .append(' ');

            return stringBuilder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Deque<Integer> integerDeque = new ArrayDeque<>();
            for (String s : data.split("\\s+")){
                integerDeque.add(Integer.valueOf(s));
            }

            return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE, integerDeque);
        }

        private TreeNode buildTree(int left, int right, Deque<Integer> deque) {
            if (deque.isEmpty()) return null;
            int val = deque.peekFirst();
            if (val < left || val > right) {
                return null;
            }
            deque.pollLast();
            TreeNode root = new TreeNode(val);
            root.right = buildTree(val, right, deque);
            root.left = buildTree(left, val, deque);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}