package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class NextGreaterElementIi{
        public static void main(String[] args) {
            Solution solution = new NextGreaterElementIi().new Solution();
            int[] rs = solution.nextGreaterElements(new int[]{1,2,3,4,5});
            System.out.println(rs);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        //{1,2,3,4,5,1,2,3,4,5}
        //[0,1,2,3,4,0,1,2,3,4]
        /** 思路:遍历每一个元素,判断其是否为开始单调递增的那个点，
         * 如果第一遍没找到就再找第二遍(相当于先从后面找再从前面找) */
        class Solution {
            public int[] nextGreaterElements(int[] nums) {
                int[] rs = new int[nums.length];
                for (int i = 0; i < rs.length; i++) {
                    rs[i] = -1;
                }
                Stack<Integer> stack = new Stack();
                for (int i = 0; i < 2*nums.length; i++) {
                    int idx = i % nums.length;
                    while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                        rs[stack.pop()] = nums[idx];
                    }
                    stack.push(idx);
                }
                return rs;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}