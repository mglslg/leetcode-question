package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses(")))()())(()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack();
            //栈底永远是每一组开头的前一个值的索引!!!
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    //只要遇到右括号就弹，弹完最后栈底剩下的那个不为空的值就是下一组的开始索引-1
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}