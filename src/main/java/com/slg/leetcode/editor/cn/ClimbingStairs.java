package com.slg.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：f(n) = f(n-1) + f(n-2)
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int current = 0;
            int last1 = 0; //f(n-1)
            int last2 = 0; //f(n-2)
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    last2 = 1;
                }else if (i == 2) {
                    last1 = 2;
                }else{
                    current = last1 + last2;
                    last2 = last1;
                    last1 = current;
                }
            }
            return current;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

