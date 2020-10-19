package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

public class LinkedListCycle{
        public static void main(String[] args) {
            Solution solution = new LinkedListCycle().new Solution();
            ListNode head = UseCaseUtil.buildLinkedList("[1,2]");
            System.out.println(solution.hasCycle(head));
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        public class Solution {
            public boolean hasCycle(ListNode head) {
                ListNode fast = head;
                ListNode slow = head;

                if (head==null) {
                    return false;
                }

                while (slow != null) {
                    slow = slow.next;
                    if (fast != null) {
                        fast = fast.next != null ? fast.next.next : null;
                    }
                    if (slow == fast && slow != null) {
                        return true;
                    }
                }
                return false;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}