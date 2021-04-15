package com.slg.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2500));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：求最大k满足 k方<=x ，k为非负整数
     * 其实就是从0~x中找这个k，因为0~x是有序的，因此可以用二分查找法！
     * 递归行不通！因为测试用例的数值可能会很大！需要改写成迭代
     */
    class Solution {
        private long result = -1;

        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            //必须使用long，不然的话用2147483647这个测试用例时间会超限……囧
            long l = 1;
            long r = x;
            while (l <= r) {
                //这样求出来的mid不是中间就是上中位
                long mid = (l + r) >> 1;

                if (mid * mid > x) {
                    r = mid - 1;
                } else {
                    result = mid;
                    l = mid + 1;
                }
            }
            return (int)result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}