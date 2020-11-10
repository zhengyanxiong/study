//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1798 👎 0


package com.Bernie.leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();
        r.gc();//计算内存前先垃圾回收一次
        long start = System.currentTimeMillis();//开始Time
        long startMem = r.freeMemory(); // 开始Memory

        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        solution.trap3(height);

        long endMem =r.freeMemory(); // 末尾Memory
        long end = System.currentTimeMillis();//末尾Time
        //输出
        System.out.println("TimeCost: "+String.valueOf(end - start)+"ms");
        System.out.println("MemoryCost: "+String.valueOf((startMem- endMem)/1024/1024)+"MB");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度：O(n²）
        // 空间复杂度：O(1）
        public int trap1(int[] height) {
            int sum = 0;
            for (int i=1;i<height.length -1;i++) {
                // left -> max height
                int maxLeft = 0;
                for (int j=i-1;j>=0;j--) {
                    if (height[j] > maxLeft) maxLeft = height[j];
                }

                // right -> max height
                int maxRight = 0;
                for (int j=i+1;j<height.length;j++) {
                    if (height[j]>maxRight) maxRight = height[j];
                }

                int minHeight = Integer.min(maxLeft,maxRight);
                if (minHeight> height[i]) sum+= minHeight - height[i];
            }

            return sum;
        }

        // 解法2：动态规划
        // 时间复杂度：O(n）
        // 空间复杂度：O(n）
        public int trap2(int[] height) {
            int sum = 0;
            int[] max_left = new int[height.length];
            int[] max_right = new int[height.length];

            for (int i=1;i<height.length - 1; i++) {
                max_left[i] = Math.max(max_left[i-1],height[i-1]);
            }

            for (int i=1;i<height.length - 1; i++) {
                max_right[i] = Math.max(max_right[i+11],height[i+1]);
            }

            for (int i=1;i<height.length -1; i++) {
                int min = Math.min(max_left[i],max_right[i]);
                if (min > height[i]) sum += min - height[i];
            }

            return sum;
        }

        // 解法3：双指针
        // 时间复杂度：O(n）
        // 空间复杂度：O(1）
        public int trap3(int[] height) {
            int sum = 0;
            int max_left=0,max_right=0;
            int left_index = 1, right_index = height.length -2;
            for (int i=1;i<height.length -1; i++) {
                if (height[left_index -1] < height[right_index + 1]) {
                    max_left = Math.max(max_left,height[left_index-1]);
                    if (max_left > height[left_index ]) sum += max_left - height[left_index];
                    left_index ++;
                } else {
                    max_right = Math.max(max_right,height[right_index + 1]);
                    if (max_right > height[right_index]) sum += max_right - height[right_index];
                    right_index --;
                }
            }

            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}