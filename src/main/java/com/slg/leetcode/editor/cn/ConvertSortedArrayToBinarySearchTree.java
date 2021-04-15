package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        int[] nums = new int[]{-10,-3,0,5,9};
        solution.sortedArrayToBST(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums, int l, int r) {
            if (r < l) {
                return null;
            }

            //r==l的情况也能cover，mid就是它本身,然后left和right都是空
            int mid = (l + r) / 2;

            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildTree(nums, l, mid - 1);
            node.right = buildTree(nums, mid + 1, r);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}