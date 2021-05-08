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

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m + n == 0) {
                return 0;
            }

            //是否为奇数
            boolean isOdd = (m + n) % 2 == 1 ? true : false;
            //如果是偶数那么找到k后再向后找一个数字即可
            int k = (m + n + 1) / 2;

            if (isOdd) {
                return find(k, nums1,nums2,0, 0);
            } else {
                return (find(k,nums1,nums2, 0, 0) + find(k + 1,nums1,nums2, 0, 0)) / 2;
            }
        }

        /**
         * 在起始索引分别为p1和p2的两个数组中，找到第k大的数
         * 想要找到第k大的数，可以先试着找第k/2大的数
         * 这样的话一次可以排除一半，从而降低时间复杂度
         * 裁着裁着最后就会变成：从两个有序数组中比较第2大的数
         */
        private double find(int k, int[] nums1, int[] nums2, int p1, int p2) {
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
                if (nums1.length - p1 > nums2.length - p2) {
                    //交换两条数组,保证nums1永远比nums2短
                    return find(k, nums2, nums1, p2, p1);
                }else{
                    int halfKth = k / 2;
                    boolean num1OutOfBound = halfKth > nums1.length - p1;
                    int compare1;
                    if(num1OutOfBound){
                        //当num1已经越界时,直接取最后一个元素做比较
                        compare1 = nums1[nums1.length - 1];
                    }else{
                        compare1 = nums1[p1 + halfKth - 1];
                    }
                    //todo 决定到底是抛弃nums1还是抛弃nums2的条件
                    if (num1OutOfBound && compare1 < nums2[p2 + halfKth - 1]) {
                        //nums1剩余的全抛弃，抛弃个数就是剩余长度
                    } else if (compare1 < nums2[p2 + halfKth - 1]) {

                    }
                }
            }

            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}