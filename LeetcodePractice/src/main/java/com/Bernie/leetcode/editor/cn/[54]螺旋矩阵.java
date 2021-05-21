package com.Bernie.leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 670 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows -1;

        while (left <= right && top <= bottom) {
            // 从左向右遍历
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            // 从上到下遍历
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                // 从右向左遍历
                for (int i = right - 1; i > left; i--) {
                    ans.add(matrix[bottom][i]);
                }

                // 从下到上
                for (int i = bottom; i > top ; i--) {
                    ans.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;

        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
