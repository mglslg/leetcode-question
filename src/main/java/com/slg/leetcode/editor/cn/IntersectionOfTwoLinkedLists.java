package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.common.ListNode;

public class IntersectionOfTwoLinkedLists{
        public static void main(String[] args) {
            Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
            ListNode a1 = new ListNode(11);
            ListNode a2 = new ListNode(12);
            ListNode a3 = new ListNode(13);
            ListNode a4 = new ListNode(14);
            ListNode a5 = new ListNode(15);
            a1.next=a2;
            a2.next=a3;
            a3.next=a4;
            a4.next=a5;

            ListNode b1=new ListNode(3);
            ListNode b2=new ListNode(2);
            ListNode b3=new ListNode(4);
            b1.next=b2;
            b2.next=b3;

            solution.getIntersectionNode(a1, b1);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：首先判断两条链表的长度,长的那一条先遍历到与短的那条齐头并进时,此时同时遍历看是否能相交
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);
            int delta = Math.abs(lengthA - lengthB);
            if (lengthA > lengthB) {
                ListNode pA = headA;
                for (int i = 0; i < delta; i++) {
                    pA = pA.next;
                }
                return getIntersection(pA, headB);
            }
            if(lengthA < lengthB){
                ListNode pB = headB;
                for (int i = 0; i < delta; i++) {
                    pB = pB.next;
                }
                return getIntersection(headA, pB);
            }
            if (lengthA == lengthB) {
                return getIntersection(headA, headB);
            }
            return null;
        }

        private ListNode getIntersection(ListNode p1, ListNode p2) {
            while (p1 != null && p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

        private int getLength(ListNode n){
            ListNode p = n;
            if (p == null) {
                return 0;
            }
            int length=1;
            while (p.next != null) {
                length++;
                p = p.next;
            }
            return length;
        }
    }
        //leetcode submit region end(Prohibit modification and deletion)
}