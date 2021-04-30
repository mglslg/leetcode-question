package com.slg.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] n1 = new int[]{3};
        int[] n2 = new int[]{1, 2, 4, 5, 6};
        solution.findMedianSortedArrays(n1, n2);
        //System.out.println((double)3/2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 找到两个数组中的第k小的数:k=(m+n)/2
     * 如果m+n为奇数，那么k就是中位数
     * 如果m+n为偶数，那么除了找到k还要找到k的下一个数
     */
    class Solution {
        private int[] nums1;
        private int[] nums2;
        private int length1;
        private int length2;

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m + n == 0) {
                return 0;
            }
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.length1 = nums1.length;
            this.length2 = nums2.length;

            //是否为奇数
            boolean isOdd = (m + n) % 2 == 1 ? true : false;
            //如果是偶数那么找到k后再向后找一个数字即可
            int k = (m + n + 1) / 2;

            if (isOdd) {
                return find(k, 0, 0);
            } else {
                return (find(k, 0, 0) + find(k + 1, 0, 0)) / 2;
            }
        }

        /**
         * 在起始索引分别为p1和p2的两个数组中，找到第k大的数
         * 想要找到第k大的数，可以先试着找第k/2大的数
         * 这样的话一次可以排除一半，从而降低时间复杂度
         * 裁着裁着最后就会变成：从两个有序数组中比较第2大的数
         */
        private double find(int k, int p1, int p2) {
            if (k == 1) {
                if (p1 < nums1.length && p2 < nums2.length) {
                    //p1和p2都没有越界的情况
                    return Math.min(nums1[p1], nums2[p2]);
                } else if (p1 < nums1.length) {
                    //p2越界
                    return nums1[p1];
                } else {
                    //p1越界
                    return nums2[p2];
                }
            } else {
                int halfKth = k / 2;
                int offset = halfKth - 1;
                int compare1 = 0;
                int compare2 = 0;
                int abandonCount = halfKth;//下一轮丢弃的个数
                boolean p1Bound = true;
                boolean p2Bound = true;

                if (p1 + offset < nums1.length && p2 + offset < nums2.length) {
                    compare1 = nums1[p1 + offset];
                    compare2 = nums2[p2 + offset];
                } else if (p1 + offset < nums1.length) {
                    compare1 = nums1[p1 + offset];
                    if (p2 < length2) {
                        //nums2在偏移后越界,直接取数组最后一个值作为比较点
                        compare2 = nums2[length2 - 1];
                        p2Bound = true;
                    } else {
                        //nums2已经全部被遍历过了,或是本来就为空
                        compare2 = Integer.MAX_VALUE;
                    }
                } else {
                    if (p1 < length1) {
                        //nums1在偏移后越界,直接取数组最后一个值作为比较点
                        compare1 = nums1[length1 - 1];
                        p1Bound = true;
                    } else {
                        //nums1已经全部被遍历过了,或是本来就为空
                        compare1 = Integer.MAX_VALUE;
                    }
                    compare2 = nums2[p2 + offset];
                }

                //谁大谁就呆着不动，然后另一个向后走，要注意计算每次丢弃掉的个数！
                if (compare1 > compare2) {
                    if (p2Bound) {
                        abandonCount = length2 - p2;
                    }
                    return find(k - abandonCount, p1, p2 + halfKth);
                } else {
                    if(p1Bound){
                        abandonCount = length1 - p1;
                    }
                    return find(k - abandonCount, p1 + halfKth, p2);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}