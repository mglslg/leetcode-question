package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

import java.util.Stack;

public class AddTwoNumbers{
        public static void main(String[] args) {
            Solution solution = new AddTwoNumbers().new Solution();
            ListNode l1 = UseCaseUtil.buildLinkedList("[9]");
            ListNode l2 = UseCaseUtil.buildLinkedList("[1,9,9,9,9,9,9,9,9,9]");
            solution.addTwoNumbers(l1, l2);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        /**
         * 思路：不能先将链表拆开变成数字运算完再拼回去，
         * 因为数字的大小未知，不管你用int还是long，最终都特娘的会超限!!!
         * 因此只能通过进位算法来实现,那么就很简单了，直接顺序相加向后进位即可！
         */
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                int carry = 0;
                ListNode rs = null;
                ListNode p1 = l1;
                ListNode p2 = l2;
                while (p1 != null && p2 != null) {
                    if(p1.val+p2.val >= 10){
                        carry=1;
                        int currVal = p1.val + p2.val - 10;
                        if (rs == null) {
                            rs = new ListNode(currVal)
                        }
                    }else{

                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == null && p2 !=null){
                    rs.next = p2;
                }
                if (p2 == null && p1 != null) {
                    rs.next = p1;
                }
                return rs;
            }

        }
        //leetcode submit region end(Prohibit modification and deletion)
}