package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.common.ListNode;

public class PalindromeLinkedList{
        public static void main(String[] args) {
                Solution solution = new PalindromeLinkedList().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public boolean isPalindrome(ListNode head) {
                if(head == null || head.next==null) return true;

                ListNode init = new ListNode(0);
                init.next=head;
                ListNode fast = init;
                ListNode slow = init;

                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                if (fast == null) {
                    //奇数链表,slow指向中位数
                    //断开链表，将后半段反转
                    ListNode halfHead = new ListNode(slow.val);
                    halfHead.next = slow.next;
                    slow.next = null;
                    ListNode reversedHead = reverseList(halfHead);
                    return isSame(head,reversedHead);
                }else{
                    //偶数链表,slow指向下中位
                    //断开链表，将后半段反转
                    ListNode halfHead = slow.next;
                    slow.next = null;
                    ListNode reversedHead = reverseList(halfHead);
                    return isSame(head,reversedHead);
                }
            }

            private ListNode reverseList(ListNode head) {
                //todo 待实现
                return null;
            }

            private boolean isSame(ListNode p1, ListNode p2) {
                while (p1 != null) {
                    if (p1.val != p2.val) {
                        return false;
                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return true;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}