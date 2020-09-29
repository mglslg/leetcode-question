package com.slg.leetcode.editor.cn;
import java.util.Stack;

public class RemoveOutermostParentheses{
        public static void main(String[] args) {
                Solution solution = new RemoveOutermostParentheses().new Solution();
            solution.removeOuterParentheses("(()())(())");
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**最优解：只要能配对,并且消除之后stack不为空,那就说明可以添加到rs中*/
            public String removeOuterParentheses(String S) {
                StringBuffer rs = new StringBuffer();
                char[] chars = S.toCharArray();
                Stack<Character> stack = new Stack();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i]==')') {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            rs.append(')');
                        }
                    }
                    if (chars[i] == '(') {
                        if (!stack.isEmpty()) {
                            rs.append('(');
                        }
                        stack.push('(');
                    }
                }
                return rs.toString();
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}