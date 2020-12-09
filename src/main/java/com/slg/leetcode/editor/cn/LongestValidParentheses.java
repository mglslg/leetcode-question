package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses(")))()())(()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        /**
         * 这个解答不行！解决不了 (() 的情况
         */
        public int longestValidParentheses(String s) {
            int max = 0;
            int startIdx = 0;
            Stack<Integer> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '('){
                    stack.push(i);
                }else{
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        int length = i - startIdx + 1;
                        if (length > max) {
                            max = length;
                        }
                    } else {
                        startIdx = i;
                    }
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}