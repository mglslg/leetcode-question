package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.common.ListNode;

public class ReverseLinkedList{
        public static void main(String[] args) {
                Solution solution = new ReverseLinkedList().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public ListNode reverseList(ListNode head) {
                if (head == null) {
                    return null;
                }
                ListNode pre = null;
                ListNode p = head;
                ListNode pn = head.next;
                while (pn != null) {
                    p.next = pre;
                    pre = p;
                    p = pn;
                    pn = pn.next;
                }
                p.next = pre;
                return p;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}