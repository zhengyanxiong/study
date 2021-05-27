//给出一个字符串 s（仅含有小写英文字母和括号）。
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 106 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("(u(love)i)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseParentheses(String s) {
            int n = s.length();
            // 记录左右括号对应的index的反转
            int[] pair = new int[n];
            Deque<Integer> stack = new LinkedList<>();
            for (int i=0; i<n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    int j = stack.pop();
                    pair[i] = j;
                    pair[j] = i;
                }
            }

            StringBuffer str = new StringBuffer();
            int index = 0, step = 1; // step 为1向右遍历，为-1向左遍历
            while (index < n) {
                if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                    // 遇到括号，改变方向
                    index = pair[index];
                    step = -step;
                } else {
                    str.append(s.charAt(index));
                }
                index += step;
            }

            return str.toString();
        }

        public String reverseParentheses1(String s) {
            int n = s.length();
            Deque<String> stack = new LinkedList<>();
            StringBuffer str = new StringBuffer();

            for (int i=0; i< n; i++) {
                char cur = s.charAt(i);
                if (cur == '(') {
                    //将 str 压栈， 清空str
                    stack.push(str.toString());
                    str.setLength(0);
                } else if (cur == ')') {
                    // 反转str
                    str.reverse();
                    str.insert(0, stack.pop());
                } else {
                    str.append(cur);
                }
            }

            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}