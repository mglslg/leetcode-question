package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class RemoveLinkedListElements{
        public static void main(String[] args) {
                Solution solution = new RemoveLinkedListElements().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) { val = x; }
         * }
         */
        class Solution {
            public ListNode removeElements(ListNode head, int val) {
                ListNode pre = null;
                ListNode p = head;
                while (p != null) {
                    if (p.val == val) {
                        if (pre != null) {
                            pre.next = p.next;
                            p = pre.next;
                        }else{
                            //第一个节点就需要被删
                            head = head.next;
                            p = head;
                        }
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