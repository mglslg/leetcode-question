package com.slg.leetcode.editor.cn;

public class MergeTwoSortedLists{
        public static void main(String[] args) {
            Solution solution = new MergeTwoSortedLists().new Solution();
            ListNode l1 = new MergeTwoSortedLists().new ListNode(1);
            l1.next = new MergeTwoSortedLists().new ListNode(2);
            l1.next.next = new MergeTwoSortedLists().new ListNode(4);

            ListNode l2 = new MergeTwoSortedLists().new ListNode(1);
            l2.next = new MergeTwoSortedLists().new ListNode(3);
            l2.next.next = new MergeTwoSortedLists().new ListNode(4);

            solution.mergeTwoLists(l1, l2);
        }

         public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {

            /**
             * 思路：遍历l1,当p1大于等于p2时将p2节点链到p1前面，否则p1向后移动
             */
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                ListNode p1 = l1;
                ListNode p2 = l2;
                ListNode p1Pre = null;
                while (p1 != null) {
                    if (p1.val < p2.val) {
                        p1Pre = p1;
                        p1 = p1.next;
                    }else{
                        //注意这里一定要赋值之后就立即把p2指向下一个，否则一旦p2cut.next一改变，p2也会跟着变,l2就丢失了!
                        ListNode p2cut = p2;
                        p2 = p2.next;

                        if (p1Pre != null) {
                            p1Pre.next = p2cut;
                        }else{
                            l1 = p2cut;
                        }
                        p2cut.next = p1;
                    }
                }
                return l1;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}