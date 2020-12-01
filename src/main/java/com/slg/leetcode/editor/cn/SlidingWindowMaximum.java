package com.slg.leetcode.editor.cn;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] rs = solution.maxSlidingWindow(nums, k);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路:
     * 构造一个双端队列,保持队列中的数从大到小排序,长度不超过k
     * 判断新数x与rpeek的值:
     *      如果x>rpeek，则持续rpop,直到不再满足这个条件,之后x入队
     *      如果x<=rpeek，则判断lpeek是否已经是当前窗口的左边界了，是的话需要lpop
     * 总结：实际上队列所维护的数据是这个窗口的一个真子集，并且从大到小排列，每次淘汰队列里不够大的数
     * 脑洞：社团每往前走一步都是在寻觅一个更厉害的老大，找到后把当前不如他的弟兄们都淘汰，退休的(滑出窗口的)自动丢掉
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] rs = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList();
            for (int i = 0; i < nums.length; i++) {
                //淘汰不够强的老人
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                //加入新人
                queue.addLast(i);
                //队列左端已经是窗口左边界了,超龄老人退休
                if (queue.peekFirst() == i - k) {
                    queue.pollFirst();
                }
                //窗口创建完成时才加入rs
                if (i >= k - 1) {
                    rs[i - k + 1] = queue.peekFirst();
                }
            }
            return rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}