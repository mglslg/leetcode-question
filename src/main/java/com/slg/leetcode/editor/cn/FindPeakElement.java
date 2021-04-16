package com.slg.leetcode.editor.cn;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 使用二分法，让mid与mid+1比较
     * 如果mid+1更大就右移，移到mid+1
     * 否则就左移，移到mid，因为mid也有可能是峰值
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                //退无可退时就是答案啊！唉~~~
                if (l == r) {
                    return l;
                }
                //当abs(r-l)==1时，mid就是左边那个数
                int mid = (l + r) / 2;
                //因为至少有两个数，因此mid+1并不溢出
                if(nums[mid]<nums[mid+1]){
                    //单调递增，所以峰值一定在右边
                    l = mid + 1;
                }else{
                    //万能的else
                    //必须得包含mid本身，因为mid可能就是那个峰值!
                    r = mid;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}