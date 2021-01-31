package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 后序遍历的数组倒排刚好就是先序遍历的镜像
         * 即从背面看的[根-左-右]，从正面看的[根-右-左]
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}