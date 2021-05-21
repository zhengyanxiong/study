//有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
//
// 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。 
//
// 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。 
//
// 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：steps = 3, arrLen = 2
//输出：4
//解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
//向右，向左，不动
//不动，向右，向左
//向右，不动，向左
//不动，不动，不动
// 
//
// 示例 2： 
//
// 输入：steps = 2, arrLen = 4
//输出：2
//解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
//向右，向左
//不动，不动
// 
//
// 示例 3： 
//
// 输入：steps = 4, arrLen = 2
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= steps <= 500 
// 1 <= arrLen <= 10^6 
// 
// Related Topics 动态规划 
// 👍 89 👎 0


package com.Bernie.leetcode.editor.cn;

class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MODULO = 1000000007;
        public int numWays(int steps, int arrLen) {
            // dp[i][j] 表示在i步操作后，指针位于下标j处的方案数
            // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
            // 由于一共执行steps步操作，所以 j的范围应该为 0 <=j<= Math.min(arrLen - 1, steps)
            int maxColumns = Math.min(arrLen -1, steps);
           /* int[][] dp = new int[steps + 1][maxColumns+1];
            dp[0][0] = 1;
            for (int i=1; i<= steps; i++) {
                for (int j=0; j<= maxColumns; j++) {
                    // 默认一个初始值，不动的位置
                    dp[i][j] = dp[i-1][j];
                    // j = 0时，dp[i-1][j-1]= 0
                    // j = maxColumns时，dp[i-1][j+1] = 0
                    if (j -1 >=0) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MODULO;
                    }
                    if (j +1 <= maxColumns) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MODULO;
                    }
                }
            }

            return dp[steps][0];*/

            int[] dp = new int[maxColumns + 1];
            dp[0] = 1;
            for (int i=1; i<=steps; i++) {
                int[] next = new int[maxColumns +1];
                for (int j=0; j<= maxColumns; j++) {
                    next[j] = dp[j];
                    if (j -1 >=0) {
                        next[j] = (next[j] + dp[j-1]) % MODULO;
                    }
                    if (j+ 1<= maxColumns) {
                        next[j] = (next[j] + dp[j+1]) % MODULO;
                    }
                }
                dp = next;
            }

            return dp[0];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}