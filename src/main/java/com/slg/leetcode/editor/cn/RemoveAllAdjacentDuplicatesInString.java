package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString{
        public static void main(String[] args) {
                Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public String removeDuplicates(String S) {
                StringBuffer rs = new StringBuffer();
                Stack<Character> stack = new Stack<>();
                char[] chars = S.toCharArray();
                for (char c : chars) {
                    if (!stack.isEmpty() && c == stack.peek()) {
                        stack.pop();
                        rs.deleteCharAt(rs.length() - 1);
                    }else{
                        stack.push(c);
                        rs.append(c);
                    }
                }
                return rs.toString();
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}