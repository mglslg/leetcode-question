package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 这题是真的阴损……难怪是面试高发题
     * 这种题要是能一把写对了绝对是背的！
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode preRs = new ListNode(-1);
            ListNode curr = null;
            ListNode p1 = l1;
            ListNode p2 = l2;
            int carry = 0;
            while (p1 != null || p2 != null) {
                int value1 = p1 == null ? 0 : p1.val;
                int value2 = p2 == null ? 0 : p2.val;

                int sum = (value1 + value2 + carry) % 10;
                if (value1 + value2 + carry >= 10) {
                    carry = 1;
                }else{
                    carry = 0;
                }
                ListNode sumNode = new ListNode(sum);

                if (curr == null) {
                    //第一个节点
                    curr = sumNode;
                    preRs.next = curr;
                }else{
                    curr.next = sumNode;
                    curr = sumNode;
                }

                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            if (carry == 1) {
                //说明最后一位也有进位，还得再加一个节点
                ListNode lastOne = new ListNode(1);
                curr.next = lastOne;
            }

            return preRs.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}