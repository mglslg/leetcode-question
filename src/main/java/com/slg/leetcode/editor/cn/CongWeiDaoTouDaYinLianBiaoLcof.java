package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        public static void main(String[] args) {
                Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (head.next != null) {
            stack.push(head.next.val);
            head = head.next;
        }
        int[] rs = new int[stack.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = stack.pop();
        }
        return rs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
	
}