package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路：不能只是和自己的根节点做比较，要保证"中序遍历的升幂排列"
     * 可以借助一个变量，每次遍历到的值都必须大于上一个遍历到的值！
     */
    class Solution {
        private TreeNode lastNode;
        private boolean result = true;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return false;
            }
            inorder(root);
            return result;
        }

        public void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            if (lastNode!=null && root.val < lastNode.val) {
                result = false;
            }
            lastNode = root;
            inorder(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}