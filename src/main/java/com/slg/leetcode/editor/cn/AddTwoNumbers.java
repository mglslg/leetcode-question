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
                long n1 = 0;
                long n2 = 0;
                Stack<Integer> stack1 = new Stack<>();
                Stack<Integer> stack2 = new Stack<>();
                ListNode p1=l1;
                ListNode p2=l2;
                while (p1 != null) {
                    stack1.push(p1.val);
                    p1 = p1.next;
                }
                while (p2 != null) {
                    stack2.push(p2.val);
                    p2 = p2.next;
                }
                while(!stack1.isEmpty()){
                    n1 = n1 * 10 + stack1.pop();
                }
                while(!stack2.isEmpty()){
                    n2 = n2 * 10 + stack2.pop();
                }
                long sum = n1 + n2;
                return buildList(sum);
            }

            public ListNode buildList(long num){
                ListNode head = null;
                ListNode tail = null;
                while (num / 10 != 0) {
                    Long x = num % 10;
                    ListNode node = new ListNode(x.intValue());
                    if (head == null) {
                        head = node;
                        tail = node;
                    }else{
                        tail.next = node;
                        tail = node;
                    }
                    num = num / 10;
                }
                if (head == null) {
                    Long x = num % 10;
                    head = new ListNode(x.intValue());
                }else{
                    Long x = num % 10;
                    ListNode node = new ListNode(x.intValue());
                    tail.next = node;
                }
                return head;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}