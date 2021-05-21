//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 756 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> tri = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(2));
                add(Arrays.asList(3,4));
                add(Arrays.asList(6,5,7));
                add(Arrays.asList(4, 1,8,3));
            }
        };
        System.out.println(solution.minimumTotal(tri));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n + 1];
            dp[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    /*int min = Math.min(triangle.get(i).get(j), triangle.get(i + 1).get(j+1)) + triangle.get(i).get(j);
                    triangle.get(i).set(j, min);*/
                    if (j != 0) dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                    else dp[j] = dp[j] + triangle.get(i).get(j);

                }

                for (int k=0; k < dp.length ; k++) {
                    System.out.print(dp[k] + " ");
                    if (k == dp.length - 1) {
                        System.out.println();
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}