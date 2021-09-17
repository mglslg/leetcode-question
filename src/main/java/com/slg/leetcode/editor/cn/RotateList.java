package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

import java.util.Stack;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
    }

    /**
     * 第一种解法：k次旋转，每一次旋转都是把最后一个节点拿上然后拼到头上
     * 构建一个stack，从里面取出最后一个节点和倒数第二个节点拼头上
     * 同时需要注意k > size 的问题，取模即可
     */
    class Solution1 {
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

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 第二种解法：将k取模拿到最小k,之后将最后k个元素拼头上，快慢指针搞定即可
     */
    class Solution2 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < k; i++) {
                if (fast.next == null) {
                    //超过一轮时重新开始走,这边也可以优化成模(但是前提需要知道链表总长度至少要遍历一次),可以免去不停的循环遍历
                    fast = head;
                } else {
                    fast = fast.next;
                }
            }
            //快慢指针间距离为0，移动0个位置，直接返回head
            if (fast == head) {
                return head;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            ListNode newHead = slow.next;
            fast.next = head;
            slow.next = null;
            return newHead;
        }
    }

    /**
     * 第三种解法：其实就是找到某一处断开链子拼到头上而已
     * 先遍历一圈得出链表长度,之后取模看看链子需要从哪断开,之后断开并拼接即可
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int length = 1;
            ListNode tail = head;
            while (tail.next != null) {
                length++;
                tail = tail.next;
            }
            ListNode p = head;
            int n = length - k % length;
            for (int i = 0; i < n - 1; i++) {
                p = p.next;
            }

            tail.next = head;
            head = p.next;
            p.next = null;

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}