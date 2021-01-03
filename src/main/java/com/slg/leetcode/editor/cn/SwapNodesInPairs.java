package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next==null) {
                return head;
            }
            ListNode newHead = head.next;
            swap(null, head);
            return newHead;
        }

        private void swap(ListNode pre, ListNode p) {
            if (p == null || p.next == null) {
                return;
            }
            //反转逻辑
            ListNode nn = p.next.next;
            //处理第一个节点时pre为null，因此不用连这一条
            if (pre != null) {
                pre.next = p.next;
            }
            p.next.next = p;
            p.next = nn;
            //下一次递归
            swap(p, nn);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}