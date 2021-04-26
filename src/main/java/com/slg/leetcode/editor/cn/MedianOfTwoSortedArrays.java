package com.slg.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 从两个数组中依次取值，先取小的，保持取出来的数单调递增
     * 找出两条数组拼起来之后的第k个数(长度为m+n)
     * 如果m+n是奇数，那么第k个数就是中位数
     * 如果m+n是偶数，那么第k个数与第k+1个数的平均值就是中位数
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m + n == 0) {
                return 0;
            }

            int k = (m + n + 1) / 2;
            boolean isOdd = (m + n) % 2 == 1 ? true : false; //是否为奇数
            int p1 = 0;
            int p2 = 0;
            double kthVal = 0;
            double kthNextVal = 0;

            //想要找到第k个数，就需要遍历k次
            for (int i = 0; i < k; i++) {
                if (p1 < nums1.length && p2 < nums2.length) {
                    if (nums1[p1] < nums2[p2]) {
                        kthVal = nums1[p1];
                        p1++;
                    } else {
                        kthVal = nums2[p2];
                        p2++;
                    }
                } else if (p1 < nums1.length) {
                    //p2到头了
                    kthVal = nums1[p1];
                    p1++;
                } else {
                    //p1到头了
                    kthVal = nums2[p2];
                    p2++;
                }
            }
            //奇数直接返回k的值，偶数找到k的下一个，然后取平均
            if (isOdd) {
                return kthVal;
            }else{
                if (p1 < nums1.length && p2 < nums2.length) {
                    if (nums1[p1] < nums2[p2]) {
                        kthNextVal = nums1[p1];
                        p1++;
                    } else {
                        kthNextVal = nums2[p2];
                        p2++;
                    }
                } else if (p1 < nums1.length) {
                    //p2到头了
                    kthNextVal = nums1[p1];
                    p1++;
                } else {
                    //p1到头了
                    kthNextVal = nums2[p2];
                    p2++;
                }
                return (kthVal+kthNextVal)/2;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}