package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class RemoveDuplicatesFromSortedList{
        public static void main(String[] args) {
            Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**
             * 已排序链表解法
             */
            public ListNode deleteDuplicates(ListNode head) {
                if (head == null) {
                    return null;
                }
                if (head.next == null) {
                    return head;
                }

                ListNode p = head.next;
                ListNode pre = head;
                while (p != null) {
                    if (p.val == pre.val) {
                        pre.next = p.next;
                        p = p.next;
                    }else{
                        pre = p;
                        p = p.next;
                    }
                }
                return head;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}