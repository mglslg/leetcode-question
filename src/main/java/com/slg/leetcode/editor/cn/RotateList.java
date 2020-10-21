package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;
import java.util.Stack;

public class RotateList{
        public static void main(String[] args) {
                Solution solution = new RotateList().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        /**
         * 第一种解法：k次旋转，每一次旋转都是把最后一个节点拿上然后拼到头上
         * 构建一个stack，从里面取出最后一个节点和倒数第二个节点拼头上
         * 同时需要注意k > size 的问题，取模即可
         *
         * 第二种解法：将k取模拿到最小k,之后将最后k个元素拼头上，快慢指针搞定即可
         */
        class Solution {
            public ListNode rotateRight(ListNode head, int k) {
                if (head == null) {
                    return null;
                }
                ListNode currHead = head;
                ListNode p = head;
                Stack<ListNode> stack = new Stack<>();
                while (p != null) {
                    stack.push(p);
                    p = p.next;
                }
                for (int i = k % stack.size(); i > 0; i--) {
                    ListNode last = stack.pop();
                    ListNode pre = stack.peek();
                    if (pre != null) {
                        pre.next = null;
                        last.next = currHead;
                    }
                    currHead = last;
                }
                return currHead;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}