package com.slg.leetcode.editor.cn;

public class MoveZeroes{
        public static void main(String[] args) {
                Solution solution = new MoveZeroes().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public void moveZeroes(int[] nums) {
                int sortedIdx = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        nums[sortedIdx] = nums[i];
                        sortedIdx++;
                    }
                }
                for (int i = sortedIdx; i < nums.length; i++) {
                    nums[i] = 0;
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}