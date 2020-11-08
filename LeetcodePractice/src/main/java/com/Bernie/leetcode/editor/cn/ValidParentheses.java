//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1961 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()[{}]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n%2 == 1) return false;

            /*Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
                put(')','(');
                put(']','[');
                put('}','{');
            }};

            Deque<Character> stack = new LinkedList<Character>();

            for (int i=0; i< n; i++) {
                char ch =  s.charAt(i);
                if (characterMap.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != characterMap.get(ch) ) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }*/
            Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
                put('(',')');
                put('[',']');
                put('{','}');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (char ch : s.toCharArray()) {
                if (characterMap.containsKey(ch)) {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty()) {
                        if (ch != characterMap.get(stack.pop())) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}