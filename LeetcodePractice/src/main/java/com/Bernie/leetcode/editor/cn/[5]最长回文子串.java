package com.Bernie.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2877 👎 0

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

        String s = "1abcdba";
        System.out.println(solution.longestPalindrome1(s));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 暴力破解法
        public String longestPalindrome1(String s) {
            int length = s.length();
            if (length < 2) return s;

            int maxLength = 1, begin = 0;
            char[] charArray = s.toCharArray();
            for (int i=0;i<length-1;i++) {
                for (int j= i +1;j<length;j++) {
                    if (j-i+1 > maxLength && validPalindromic(charArray,i,j)) {
                        maxLength = j - i +1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLength);
        }

        /**
         * @param: charArray
         * @param: begin
         * @param: end
         * @description: 校验是不是回文数
         * @return: boolean
         * @author: Bernie
         * @date: 2020/11/8
         */
        public boolean validPalindromic(char[] charArray, int begin, int end) {
            while (begin < end) {
                if (charArray[begin] != charArray[end]) return false;
                begin++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}