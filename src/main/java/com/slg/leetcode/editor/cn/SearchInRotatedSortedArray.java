package com.slg.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println(solution.search(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：每次二分之后左右一定一边有序一边无序，先判断当前区间是有序还是无序
     * 然后只从有序的开始找！只从有序的开始找！只从有序的开始找！
     * 背锅交给else！背锅交给else！背锅交给else！
     */
    class Solution {

        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[l]) {
                    //左侧有序,先从左侧找
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    //右侧有序,先从右侧找
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}