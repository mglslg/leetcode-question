package com.slg.leetcode.editor.cn;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用二分法，让mid后与mid-1和mid+1进行比较
     * 如果如果mid最大则直接返回
     * 如果mid<mid+1，那么往右走，反之往左走
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;

            //记得要考虑l或者r就是峰值的情况
            //不会出现l等于r的情况！至少要有两个数字比较才有意义！
            while (l < r) {
                int mid = (l + r) / 2;

                if (l + 1 == r) {
                    if (nums[l] > nums[r]) {
                        return l;
                    }
                    if (nums[l] < nums[r]) {
                        return r;
                    }
                }

                //todo

                //防止溢出,一旦溢出就让其等于mid本身
                int leftIdx = mid - 1 < l ? mid : mid - 1;
                int rightIdx = mid + 1 > r ? mid : mid + 1;

                if (nums[leftIdx] < nums[mid] && nums[mid] > nums[rightIdx]) {
                    return mid;
                }
                if (nums[leftIdx] < nums[mid] && nums[mid] < nums[rightIdx]) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}