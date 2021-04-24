package com.slg.leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路：每次取整数的末尾，放到结果的后面，取末尾的方法就是取模！取模！取模！
     * 1234取4,需要1234%10=4,模10之后余数肯定是个个位数,因此一定取的是最后一位的值！
     * 这题还有个问题就是整数溢出的问题，如何判断是否溢出呢？
     * 可以用long啊哈哈!
     * 或者也可以用long型的rs跟Integer.MAXVALUE做比较，如果大于了就是溢出了
     */
    class Solution {
        public int reverse(int x) {
            long rs = 0;
            int num = x;
            while (Math.abs(num) > 0) {
                int lastBit = num % 10;
                //不用考虑正负,负数加负数还是负数
                rs = rs * 10 + lastBit;
                num = num / 10;
            }
            //注意这个写法！思路很赞啊哈哈
            if ((int) rs == rs) {
                return (int) rs;
            }else{
                return 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}