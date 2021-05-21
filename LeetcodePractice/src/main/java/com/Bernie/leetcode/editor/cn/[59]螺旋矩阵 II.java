//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 355 👎 0


package com.Bernie.leetcode.editor.cn;

class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] res = solution.generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n < 0) return new int[0][];
            int[][] ans = new int[n][n];
            int allNums = n * n;
            int left = 0, top = 0, right = n - 1, bottom = n - 1, num = 1;
            while (num <= allNums) {
                // left -> right
                for (int i = left; i <= right; i++) {
                    ans[left][i] = num++;
                }
                top++;
                // top->bottom
                for (int i = top; i <= bottom; i++) {
                    ans[i][right] = num++;
                }
                right--;
                // right -> left
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
                // bottom -> top
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
                left++;

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}