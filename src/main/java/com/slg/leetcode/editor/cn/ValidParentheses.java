package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses{
        public static void main(String[] args) {
                Solution solution = new ValidParentheses().new Solution();
                solution.isValid("([)]");
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public boolean isValid(String s) {
                HashMap<Character, Character> bracket = new HashMap();
                bracket.put('(', ')');
                bracket.put('[', ']');
                bracket.put('{', '}');
                Stack<Character> stack = new Stack();

                char[] arry = s.toCharArray();
                for (char c : arry) {
                    if(stack.isEmpty()){
                        stack.push(c);
                        continue;
                    }
                    char top = stack.peek();
                    if (bracket.get(top)!=null && bracket.get(top)==c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                return stack.isEmpty();
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}