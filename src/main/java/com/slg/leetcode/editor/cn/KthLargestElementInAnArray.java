package com.slg.leetcode.editor.cn;

import java.util.Arrays;

public class KthLargestElementInAnArray{
        public static void main(String[] args) {
                Solution solution = new KthLargestElementInAnArray().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int val=nums.length-k;
        return nums[val];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
	
}