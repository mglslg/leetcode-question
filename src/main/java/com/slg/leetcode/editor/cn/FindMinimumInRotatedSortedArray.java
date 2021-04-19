package com.slg.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        solution.findMin(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 通过与nums[0]比较来判定当前mid属于高个区还是矮个区
     * 之后决定是向左走还是向右走
     * 是否包含mid取决于mid有没有可能是最终结果！！！
     */
    class Solution {
        public int findMin(int[] nums) {
            //没有旋转过的完全单调递增，直接取第一个
            if (nums[nums.length - 1] > nums[0]) {
                return nums[0];
            }
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                if (l == r) {
                    return nums[l];
                }
                int mid = (l + r) / 2;
                if (nums[mid] >= nums[0]) {
                    //在高个区，向右走
                    l = mid + 1;
                } else {
                    //在矮个区，向左走，mid也可能就是最终结果，因此保留到下一轮
                    r = mid;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}