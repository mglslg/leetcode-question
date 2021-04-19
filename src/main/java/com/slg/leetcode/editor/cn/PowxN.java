package com.slg.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(2, -3 ));
    }

    //leetcode submit region begin(Prohibit modification and deletion
    /**
     * 思路：二分法，利用公式x^n=x^(n/2)*x^(n/2)
     * 测试用例：0.00001，2147483647不通过，神马垃圾玩意！
     * 自己跑没啥问题，应该能通过
     */
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n > 0) {
                return powHelper(x, n);
            }
            if (n < 0) {
                return powHelper(1 / x, Math.abs((long)n));//防止超限
            }
            return 0;
        }

        private double powHelper(double x, long pow) {
            if (pow > 1) {
                if (pow % 2 == 0) {
                    //偶数
                    return powHelper(x, pow / 2) * powHelper(x, pow / 2);
                }else{
                    //奇数
                    return powHelper(x, pow / 2) * powHelper(x, pow / 2) * x;
                }
            }
            //这里pow一定为1
            return x;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}