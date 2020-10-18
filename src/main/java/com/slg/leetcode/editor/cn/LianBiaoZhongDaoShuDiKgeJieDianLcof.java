package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
        public static void main(String[] args) {
                Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)

        class Solution {
            /**
             * 思路：用两个指针，先让一个指针走k步，之后两个指针同时向前走，
             * 当快指针到头时慢指针即为倒数第k个……呵呵呵
             */
            public ListNode getKthFromEnd(ListNode head, int k) {
                ListNode fast = head;
                ListNode slow = head;
                for (int i = 0; i < k; i++) {
                    fast = fast.next;
                }
                while (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}