package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class ReverseLinkedList{
        public static void main(String[] args) {
                Solution solution = new ReverseLinkedList().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            //递归解法 1->2-> 3 ->4<-5<-6<-7 假设head=3时，右侧全部翻转，左侧尚未翻转
            //需要做的就是把4指向3，把3指向空
            public ListNode reverseList(ListNode head) {
                if (head==null || head.next == null) {
                    return head;
                }
                ListNode p = reverseList(head.next);//此时p就是7，head就是3
                head.next.next=head;//这句就是典型的翻转语句
                head.next = null;
                return p;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
}