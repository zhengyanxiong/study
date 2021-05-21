//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 222 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.TreeSet;

class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                int[] columns = new int[cols];
                for (int j = i; j < rows; j++) {
                    for (int l = 0; l < cols; l++) { // 累计每一行的和
                        columns[l] += matrix[j][l];
                    }
                    TreeSet<Integer> sumSet = new TreeSet<>();
                    sumSet.add(0);
                    int s = 0;
                    for (int v : columns) {
                        s += v;
                        Integer ce = sumSet.ceiling(s - k);
                        if (ce != null) {
                            max = Math.max(max, s - ce);
                        }
                        sumSet.add(s);
                    }
                }
            }

            return max;
        }

        public int maxSumSubmatrix2(int[][] matrix, int k) {
            int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
            for (int i = 0; i < cols; i++) { //枚举左边界
                int[] rowSums = new int[rows];
                for (int j = i; j < cols; j++) { // 枚举右边界
                    for (int l = 0; l < rows; l++) { // 累计每一行的和
                        rowSums[l] += matrix[l][j];
                    }
                    max = Math.max(max, dpMax(rowSums, k));
                    if (max == k) return k;
                }
            }

            return max;
        }

        private int dpMax(int[] arr, int k) {
            int rollSum = arr[0], rollMax = rollSum;
            // O(rows)
            for (int i = 1; i < arr.length; i++) {
                if (rollSum > 0) rollSum += arr[i];
                else rollSum = arr[i];
                if (rollSum > rollMax) rollMax = rollSum;
            }
            if (rollMax <= k) return rollMax;
            // O(rows ^ 2)
            int max = Integer.MIN_VALUE;
            for (int l = 0; l < arr.length; l++) {
                int sum = 0;
                for (int r = l; r < arr.length; r++) {
                    sum += arr[r];
                    if (sum > max && sum <= k) max = sum;
                    if (max == k) return k; // 尽量提前
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}