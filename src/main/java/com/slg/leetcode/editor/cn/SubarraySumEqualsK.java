package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 0, 3};
        Solution solution = new SubarraySumEqualsK().new Solution();
        solution.subarraySum(nums, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                if (map.containsKey(sum - k)) {
                    count = count + map.get(sum - k) ;
                }
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum) + 1);
                }else{
                    map.put(sum, 1);
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}