//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
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
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 360 👎 0


package com.Bernie.leetcode.editor.cn;

class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] s = new int[][] {{1,3,5,7}, {10,11,16,20},{23,30,34,60}};
        System.out.println(solution.searchMatrix(s, 13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowIndex = searchRow(matrix, target);
            if (rowIndex < -1) return false;

            return searchColum(matrix[rowIndex], target);
        }

        private boolean searchColum(int[] matrix, int target) {
            int low = 0, height = matrix.length - 1;
            while (low <= height) {
                int middle = (height - low + 1)/2;
                if (matrix[middle] == target) {
                    return true;
                } else if (matrix[middle]<target) {
                    low = middle + 1;
                } else {
                    height = middle - 1;
                }
            }
            return false;
        }

        private int searchRow(int[][] matrix, int target) {
            int low = -1, top = matrix.length - 1;
            while (low < top) {
                int middle = (top - low + 1) /2 + low;
                if (matrix[middle][0]<= target) {
                    low = middle;
                } else {
                    top = middle - 1;
                }
            }

            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}