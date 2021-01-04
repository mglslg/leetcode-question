package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> cache = new HashMap<>();
        /**
         * 思路：f(n) = f(n-1) + f(n-2)
         * 带缓存的递归解法(不带缓存的话重复计算太多了，到n==45时就会超时……)
         */
        public int climbStairs(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int fn1 = cache.get(n - 1) != null ? cache.get(n - 1) : climbStairs(n - 1);
            int fn2 = cache.get(n - 2) != null ? cache.get(n - 2) : climbStairs(n - 2);
            cache.put(n - 1, fn1);
            cache.put(n - 2, fn2);
            return fn1 + fn2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

