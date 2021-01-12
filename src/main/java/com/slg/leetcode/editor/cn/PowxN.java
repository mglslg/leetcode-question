package com.slg.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(2, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion

    /**
     * 计算x的n次幂:暴力法(测试用例通不过)
     */
    class Solution {

        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double result;
            if (n < 0) {
                result = 1 / x;
                for (int i = 1; i < (0 - n); i++) {
                    result = result * (1/x);
                }
                return result;
            }else{
                result = x;
                for (int i = 1; i < n; i++) {
                    result = result * x;
                }
                return result;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}