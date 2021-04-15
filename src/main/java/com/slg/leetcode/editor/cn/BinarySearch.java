package com.slg.leetcode.editor.cn;

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int result = -1;
        private int target = 0;

        public int search(int[] nums, int target) {
            this.target = target;
            binary(nums, 0, nums.length - 1);
            return result;
        }

        private void binary(int[] nums, int l, int r) {
            if (l > r) {
                return ;
            }
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                binary(nums, mid + 1, r);
            }
            if (target < nums[mid]) {
                binary(nums, l, mid - 1);
            }
            if (target == nums[mid]) {
                result = mid;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}