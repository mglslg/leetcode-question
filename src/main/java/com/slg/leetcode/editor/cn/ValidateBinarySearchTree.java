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

        /**
         * 重要的是弄明白每次递归函数返回时各个全局变量的状态都是什么
         * 例如isValidBST(root.left)在调用完成之后,lastNode就停留在root.left的值上
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                //这里我真的没想到不用考虑整棵树为空的情况……
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (lastNode != null && root.val <= lastNode.val) {
                return false;
            }
            lastNode = root;

            //已经利用左子树判断了当前节点,因此是否为BST就取决于右子树了
            return isValidBST(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}