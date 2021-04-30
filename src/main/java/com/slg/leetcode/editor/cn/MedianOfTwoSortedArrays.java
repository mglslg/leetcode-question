package com.slg.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 想象将两个数组合并成一个有序数组，k=(m+n)/2
     * 如果是奇数，那么就要找到下标为[k]的元素
     * 如果是偶数，那么就要找到下标为[k-1]和[k]这两个元素
     * 那么其实就不必每个元素都遍历，二分法跳着找到k即可，每次都可以丢弃一些一定不会是答案的数列
     * 由于k是两个数组合并后的下标，因此每个数组的右边界其实是k/2
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m + n == 0) {
                return 0;
            }
            //是否为奇数
            boolean isOdd = (m + n) % 2 == 1 ? true : false;
            int p1 = 0;
            int p2 = 0;
            double pre=0;
            double kVal=0;

            //想象为一个长度为m+n的新数组，(m+n)/2刚好能取到下中位
            for (int i = 0; i <= (m + n) / 2; i++) {
                pre = kVal;
                if (p1 < nums1.length && p2 < nums2.length) {
                    if (nums1[p1] < nums2[p2]) {
                        kVal = nums1[p1];
                        p1++;
                    }else{
                        kVal = nums2[p2];
                        p2++;
                    }
                } else if (p1 < nums1.length) {
                    kVal=nums1[p1];
                    p1++;
                } else {
                    kVal=nums2[p2];
                    p2++;
                }
            }

            if(isOdd){
                return kVal;
            }else{
                return (pre+kVal)/2;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}