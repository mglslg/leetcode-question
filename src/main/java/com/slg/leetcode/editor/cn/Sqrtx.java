package com.slg.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：求最大k满足 k方<=x ，k为非负整数
     * 其实就是从0~x中找这个k，因为0~x是有序的，因此可以用二分查找法！
     * 然后找的时候先从右边找满足k方小于等于x的，没有再去左边，这样最终找到的就是最大的值
     *
     * 有问题，二分查找的l和r没有找到呢还！！先做一个纯二分查找的东西!
     */
    class Solution {
        private int result = -1;

        public int mySqrt(int x) {
            return calc(x, x);
        }

        private int calc(int x, int curr) {
            //这样求出来的是mid不是中间就是上中位
            int mid = (curr+1) / 2;

            if (mid * mid <= x) {
                result = mid > result ? mid : result;
            }else{
                result = calc(x, mid);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}