package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString{
        public static void main(String[] args) {
                Solution solution = new DecodeString().new Solution();
            solution.decodeString("100[leetcode]");
            //solution.decodeString("3[a]2[bc]");
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public String decodeString(String s) {
                char[] chars = s.toCharArray();
                Stack<Character> stack = new Stack<>();
                StringBuffer rs = new StringBuffer();
                for (char c : chars) {
                    Stack<Character> tempStack = new Stack<>();
                    List<Character> tempList = new ArrayList<>();
                    if (c == ']') {
                        while (stack.peek() != '[') {
                            tempStack.push(stack.pop());
                        }

                        stack.pop();//弹出'['

                        //找出k
                        int k = 0;
                        Stack<Character> numStack = new Stack();
                        while (!stack.isEmpty() && isDigit(stack.peek())) {
                            numStack.push(stack.pop());
                        }
                        while (!numStack.isEmpty()) {
                            //[4,2,1,3] => 4, 4*10+2, 42*10+1, 421*10+3 相当于原数左移并加新数
                            k = k * 10 + charToInt(numStack.pop());
                        }

                        //保存重复的串
                        while(!tempStack.empty()){
                            tempList.add(tempStack.pop());
                        }

                        //解码
                        for (int i = 0; i < k; i++) {
                            for (char tc : tempList) {
                                stack.push(tc);
                            }
                        }
                    }else{
                        stack.push(c);
                    }
                }
                Stack<Character> rsTemp = new Stack<>();
                while (!stack.isEmpty()) {
                    rsTemp.push(stack.pop());
                }
                while (!rsTemp.isEmpty()) {
                    rs.append(rsTemp.pop());
                }
                return rs.toString();
            }

            private boolean isDigit(char c) {
                if (c >= '0' && c <= '9') {
                    return true;
                }
                return false;
            }

            private int charToInt(char c) {
                return c - '0';
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}