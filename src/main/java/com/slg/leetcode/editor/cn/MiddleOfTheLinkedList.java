package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class MiddleOfTheLinkedList{
        public static void main(String[] args) {
                Solution solution = new MiddleOfTheLinkedList().new Solution();
        }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public ListNode middleNode(ListNode head) {
                if(head==null) return head;

                //构造一个初始化节点,创建快慢指针,快指针一次走2步，慢指针一次走1步
                //之所以创建这个初始化节点是因为这样才有可能返回下中位(尽管题目要求的是返回上中位)
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
                    return slow;
                }else{
                    //偶数链表,slow指向下中位,题目要求返回上中位
                    return slow.next;
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}