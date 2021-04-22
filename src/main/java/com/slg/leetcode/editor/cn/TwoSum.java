package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] rs = new int[2];
            Map<Integer,Integer> memo = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (memo.keySet().contains(target - nums[i])) {
                    rs[0] = memo.get(target - nums[i]);
                    rs[1] = i;
                    return rs;
                }
                memo.put(nums[i], i);
            }
            return rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}