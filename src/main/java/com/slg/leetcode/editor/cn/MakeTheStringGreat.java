package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class MakeTheStringGreat{
        public static void main(String[] args) {
                Solution solution = new MakeTheStringGreat().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        /**还有一种方法是让字符相减然后取绝对值等于32(其中32可以用'A'-'a'得到)*/
        class Solution {
            public String makeGood(String s) {
                StringBuffer rs = new StringBuffer();
                char[] chars = s.toCharArray();
                Stack<Character> stack = new Stack<Character>();

                for(char c:chars){
                    if (!stack.isEmpty() && isPair(stack.peek(), c)) {
                        stack.pop();
                        rs.deleteCharAt(rs.length() - 1);
                    } else {
                        stack.push(c);
                        rs.append(c);
                    }
                }
                return rs.toString();
            }

            boolean isPair(char a, char b) {
                if (Character.isLowerCase(a)
                        && Character.isUpperCase(b)
                        && Character.toUpperCase(a) == b) {
                    return true;
                }
                if (Character.isUpperCase(a)
                        && Character.isLowerCase(b)
                        && Character.toLowerCase(a) == b) {
                    return true;
                }
                return false;
            }
        }

        //leetcode submit region end(Prohibit modification and deletion)
	
}