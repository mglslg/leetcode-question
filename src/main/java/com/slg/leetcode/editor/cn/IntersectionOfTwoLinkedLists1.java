package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class IntersectionOfTwoLinkedLists1 {
        public static void main(String[] args) {
                Solution solution = new IntersectionOfTwoLinkedLists1().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                ListNode pa = headA;
                ListNode pb = headB;
                boolean joinedA = false;
                boolean joinedB = false;
                while(true){
                    if (pa.next == null && !joinedA) {
                        pa.next = headB;
                        joinedA = true;
                    }
                    if (pb.next == null && !joinedB) {
                        pb.next = headA;
                        joinedB = true;
                    }
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}