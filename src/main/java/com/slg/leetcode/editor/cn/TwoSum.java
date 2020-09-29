package com.slg.leetcode.editor.cn;

import java.util.HashMap;

public class TwoSum{

        public static void main(String[] args) {
                Solution solution = new TwoSum().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)

        class Solution {
            public int[] twoSum(int[] nums, int target) {
                int[] rs = new int[2];
                //类似倒排索引
                HashMap<Integer, Integer> numMap = new HashMap();
                for (int i = 0; i < nums.length; i++) {
                    if (numMap.containsKey(target - nums[i])) {
                        rs[0]=i;
                        rs[1] = numMap.get(target - nums[i]);
                        return rs;
                    }
                    numMap.put(nums[i], i);
                }
                return null;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}