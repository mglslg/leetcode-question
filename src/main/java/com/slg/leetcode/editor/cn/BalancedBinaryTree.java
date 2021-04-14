package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        Integer[] arr = new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root = UseCaseUtil.buildTree(arr);
        solution.isBalanced(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 注意！是每个节点！每个节点的左右子树高度差不超过1，而不是根节点的左右子树高度差不超过1 ！
     */
    class Solution {
        //用于记录每个节点的高度
        private Map<TreeNode, Integer> heightMap = new HashMap<>();

        public boolean isBalanced(TreeNode root) {
            height(root);

            return isBalancedHelper(root);
        }

        private boolean isBalancedHelper(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftHeight = root.left == null ? 0 : heightMap.get(root.left);
            int rightHeight = root.right == null ? 0 : heightMap.get(root.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
            return isBalancedHelper(root.left) && isBalancedHelper(root.right);
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
            int height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
            heightMap.put(root, height);
            return height;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}