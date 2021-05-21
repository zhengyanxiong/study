 //给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 573 👎 0

  
package com.Bernie.leetcode.editor.cn;

 import java.util.Arrays;

 class LargestNumber{
    public static void main(String[] args) {
         Solution solution = new LargestNumber().new Solution();
        //System.out.println(solution.largestNumber(new int[]{1, 20,3,30}));
        String[] s = new String[] {"1", "2", "3", "0"};
        Arrays.sort(s, (a,b) -> {
            System.out.println(a + " " + b + " " +(a+b).compareTo(b+a));
            return (a+b).compareTo(b+a);
        });
        Arrays.stream(s).forEach(System.out::print);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int n  = nums.length;
        String[] numsToS = new String[n];
        for (int i = 0; i < n; i++) {
            numsToS[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsToS, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        if (numsToS[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(numsToS[i]);
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }