package com.slg.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList{
        public static void main(String[] args) {
            Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
            ListNode n1 = new RemoveDuplicatesFromSortedList().new ListNode(1);
            ListNode n2 = new RemoveDuplicatesFromSortedList().new ListNode(1);
            ListNode n3 = new RemoveDuplicatesFromSortedList().new ListNode(1);
            n1.next = n2;
            n2.next = n3;
            solution.deleteDuplicates(n1);
        }

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
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