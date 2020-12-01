package com.slg.leetcode.editor.cn;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        solution.maxSlidingWindow(nums, k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路:
     * 1、构造一个双向链表,窗口向右移动时,先lpop,再rpush
     * 2、设置max变量记录当前窗口最大值
     * 3、lpop后,?
     * 4、rpush时,如果小于max则不必push,如果大于则更新max
     * 2、新来的数字如果小于最左侧数据则不做rpush,如果大于最左侧数据则设置到max
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList queue = new LinkedList();


            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}