//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：下面是两条和最小的下降路径，用加粗标注：
//[[2,1,3],      [[2,1,3],
// [6,5,4],       [6,5,4],
// [7,8,9]]       [7,8,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：下面是一条和最小的下降路径，用加粗标注：
//[[-19,57],
// [-40,-5]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[-48]]
//输出：-48
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 动态规划 
// 👍 88 👎 0


package com.Bernie.leetcode.editor.cn;

class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] f = new int[n][n];

            for (int i = 0; i< n; i++) {
                f[0][i] = matrix[0][i];
            }

            for (int i=1; i< n; i++) {
                for (int j = 0; j< n; j++) {
                    int val = matrix[i][j];
                    f[i][j] = f[i-1][j] + val;
                    // f[i][j] 从f[i-1][j-1]转移过来
                    if (j -1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] +val);
                    }
                    // f[i][j]从f[i-1][j+1]转移过来
                    if (j + 1 < n) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j+1] +val);
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int i=0; i< n; i++) {
                ans = Math.min(ans, f[n-1][i]);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}