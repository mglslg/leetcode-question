package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.subsets(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> sub = new ArrayList<>();
            int n = nums.length;
            //共有这么多种情况
            int totalNum = 1 << n;
            for (int i = 0; i < totalNum; i++) {
                List<Integer> currSub = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    // 遍历每一个位置,由于1<<j的二进制数只有一位为1，因此每一次1<<j相当于将位置向左移动1格
                    // 那么做&运算时即可知道当前位置j是否在i这种情况中
                    if ((i & (1 << j)) != 0) {
                        currSub.add(nums[j]);
                    }
                }
                sub.add(currSub);
            }
            return sub;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> sub = new ArrayList<>();
            int n = nums.length;
            int totalNum = 1 << n;
            for (int i = 0; i < totalNum; i++) {
                List<Integer> currSub = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << n)) != 0) {
                        currSub.add(nums[j]);
                    }
                }
                sub.add(currSub);
            }
            return sub;
        }
    }
}