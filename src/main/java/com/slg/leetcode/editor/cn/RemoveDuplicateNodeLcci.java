package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci{
        public static void main(String[] args) {
            Solution solution = new RemoveDuplicateNodeLcci().new Solution();
            ListNode head = UseCaseUtil.buildLinkedList("[1, 2, 3, 3, 2, 1]");
            solution.removeDuplicateNodes(head);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public ListNode removeDuplicateNodes(ListNode head) {
                Set<Integer> set = new HashSet<>();
                ListNode pre = null;
                ListNode p = head;
                while (p != null) {
                    if (set.contains(p.val)) {
                        pre.next = p.next;
                        p = pre.next;
                    }else{
                        set.add(p.val);
                        pre = p;
                        p = p.next;
                    }
                }
                return head;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
	
}