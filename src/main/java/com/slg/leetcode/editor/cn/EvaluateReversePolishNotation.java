package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateReversePolishNotation{
        public static void main(String[] args) {
                Solution solution = new EvaluateReversePolishNotation().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int evalRPN(String[] tokens) {
                ArrayList<String> ops = new ArrayList();
                ops.add("+");
                ops.add("-");
                ops.add("*");
                ops.add("/");

                Stack<String> stack = new Stack<>();
                int rs = 0;
                for (String e : tokens) {
                    if (ops.contains(e)) {
                        String b = stack.pop();
                        String a = stack.pop();
                        rs = calculate(Integer.parseInt(a), Integer.parseInt(b), e);
                        stack.push(String.valueOf(rs));
                    }else{
                        rs = Integer.parseInt(e);
                        stack.push(e);
                    }
                }
                return rs;
            }

            int calculate(int a, int b, String op) {
                switch (op){
                    case "+":
                        return a+b;
                    case "-":
                        return a-b;
                    case "*":
                        return a*b;
                    case "/":
                        return a / b;
                    default:
                        return 0;
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}