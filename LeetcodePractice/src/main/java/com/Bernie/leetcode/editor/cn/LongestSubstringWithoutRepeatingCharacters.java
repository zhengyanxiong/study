//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4587 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring1(String s) {
            Set<Character> sc = new HashSet<>();
            int length = s.length();
            int rightIndex = -1, ans = 0;
            for (int i=0;i<length;i++) {
                if (i!=0) {
                    sc.remove(s.charAt(i -1));
                }
                while (rightIndex +1 < length  && !sc.contains(s.charAt(rightIndex + 1))) {
                    sc.add(s.charAt(rightIndex + 1));
                    ++rightIndex;
                }

                ans = Math.max(ans, rightIndex - i + 1);
            }
            return ans;
        }

        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> hashMap = new HashMap<>();
            int length = s.length();
            int start = 0, ans = 0;
            for (int end=0;end<length;end++) {
                if (hashMap.containsKey(s.charAt(end))) {
                    start = Math.max(start, hashMap.get(s.charAt(end)));
                }
                ans = Math.max(ans,end-start +1);
                hashMap.put(s.charAt(end),end+1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}