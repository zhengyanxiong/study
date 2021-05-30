//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1628 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Map;

class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length(), m = word2.length();

            // 有一个字符串为空情况
            if (n * m == 0) {
                return n + m;
            }

            // 定义dp[i][j] 数组, 表示 word1的前i个字母和word2的前j个字母之间的编辑距离
            int[][] dp = new int[n + 1][m + 1];

            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j < m + 1; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int down = dp[i-1][j] + 1;
                    int left = dp[i][j-1] + 1;
                    int leftDown = dp[i-1][j-1];
                    if (word1.charAt(i-1) != word2.charAt(j-1)) {
                        leftDown +=1;
                    }
                    dp[i][j] = Math.min(left, Math.min(down, leftDown));
                }
            }
            return dp[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}