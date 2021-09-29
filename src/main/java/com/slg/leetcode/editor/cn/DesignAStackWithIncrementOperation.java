package com.slg.leetcode.editor.cn;

public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack solution = new DesignAStackWithIncrementOperation().new CustomStack(3);
        solution.push(1);
        solution.push(2);
        solution.pop();
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.increment(5,100);
        solution.increment(2,100);
        solution.pop();
        solution.pop();
        solution.pop();
        solution.pop();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
    //[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
    class CustomStack {
        int max = 0;
        int[] stack;

        //要搞明白peek到底是啥,不然容易坑,peek就是指向当前栈顶的元素,而不是栈顶的下一个元素！
        //因此初始化必须为-1
        int peek = -1;

        public CustomStack(int maxSize) {
            max = maxSize;
            stack = new int[max];
        }

        public void push(int x) {
            //栈顶的下一个元素如果越界的话就返回
            if (peek+1 > max - 1) {
                return;
            }
            peek++;
            stack[peek] = x;
        }

        public int pop() {
            if (peek < 0) {
                return -1;
            }
            int rs = stack[peek];
            peek--;
            return rs;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k; i++) {
                if (i >= max) {
                    break;
                }
                stack[i] = stack[i] + val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}