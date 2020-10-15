package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

public class IntersectionOfTwoLinkedLists{
        public static void main(String[] args) {
            Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
            ListNode headA = UseCaseUtil.buildLinkedList("[4,1,8,4,5]");
            ListNode headB = UseCaseUtil.buildLinkedList("[5,6,1,8,4,5]");
            solution.getIntersectionNode(headA, headB);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        /**
         * 思路：p1,p2同时遍历两条链表，到尾之后链到另一个头上
         * 就等于每个指针都完整遍历一次两条链表
         * 每个链表被遍历两次,p1p2最终走过的路程相等,并在终点相遇
         * "可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的"
         */
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                ListNode pa = headA;
                ListNode pb = headB;
                if(pa==null || pb==null){
                    return null;
                }

                //注意！这里不能改变链表的结构！只能判断相等而不能使用next链过去！
                //而且当pa指向headB时就不能同时再用pa.next了否则会移动两次
                while (pa != pb) {
                    if (pa == null) {
                        pa = headB;
                    }else{
                        pa = pa.next;
                    }
                    if (pb == null) {
                        pb = headA;
                    }else{
                        pb = pb.next;
                    }
                }
                return pa;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}