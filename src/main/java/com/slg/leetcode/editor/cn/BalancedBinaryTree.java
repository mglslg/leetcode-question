package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        Integer[] arr = new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root = UseCaseUtil.buildTree(arr);
        solution.isBalanced(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 巧妙利用数值类型的返回值将一些状态带出去！
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            return height(root)==-1?false:true;
        }

        /**
         * 初始化高度map
         */
        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            //已经判断出不满足btree的条件了，直接用一个特殊值把这个信儿带出去就行了啊！
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            }else{
                return  (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}