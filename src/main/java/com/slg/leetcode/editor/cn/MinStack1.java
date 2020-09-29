package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class MinStack1 {
        public static void main(String[] args) {

        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class MinStack {
            Stack<Integer> stack =null;

            /** initialize your data structure here. */
            public MinStack() {
                stack = new Stack<Integer>();
            }

            public void push(int x) {
                int min = Integer.MAX_VALUE;
                if (!stack.isEmpty()) {
                    min = stack.peek();
                }
                stack.push(x);
                if (x < min) {
                    stack.push(x);
                }else{
                    stack.push(min);
                }
            }

            public void pop() {
                stack.pop();
                stack.pop();
            }

            public int top() {
                int min = stack.pop();
                int top = stack.peek();
                stack.push(min);
                return top;
            }

            public int getMin() {
                return stack.peek();
            }
        }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
	
}