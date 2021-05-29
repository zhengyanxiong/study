//给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
//
// 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。 
//
//
// 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵
//也不同。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
//输出：4
//解释：四个只含 0 的 1x1 子矩阵。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,-1],[-1,1]], target = 0
//输出：5
//解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[904]], target = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= matrix.length <= 100 
// 1 <= matrix[0].length <= 100 
// -1000 <= matrix[i] <= 1000 
// -10^8 <= target <= 10^8 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 115 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int ans = 0;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                int[] sum = new int[n];
                for (int j = i; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        sum[k] += matrix[j][k];
                    }
                    ans += subarraySum(sum, target);
                }
            }
            return ans;
        }

        private int subarraySum(int[] nums, int target) {
            int count = 0, pre = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            for (int num : nums) {
                pre += num;

                if (map.containsKey(pre - target)) {
                    count += map.get(pre - target);
                }

                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }

            return count;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}