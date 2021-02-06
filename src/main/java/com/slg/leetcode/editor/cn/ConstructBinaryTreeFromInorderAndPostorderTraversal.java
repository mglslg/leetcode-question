package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

        solution.buildTree(
                new int[]{9,3,15,20,7},
                new int[]{9,15,7,20,3}
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] postorder;
        private Map<Integer, Integer> inorderMap = new HashMap<>();
        /**
         * 后序遍历的数组倒排刚好就是先序遍历的镜像
         * 即从背面看的[根-左-右]，从正面看的[根-右-左]
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            if (inorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            return helper(postorder.length - 1, 0, inorder.length-1);
        }

        private TreeNode helper(int rootIdx, int start, int end) {
            if (start > end) {
                return null;
            }
            int rootVal = postorder[rootIdx];
            int inorderIdx = inorderMap.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            int rightSectionLength = end - inorderIdx;
            root.left = helper(rootIdx - rightSectionLength-1 , start, inorderIdx - 1);
            root.right = helper(rootIdx - 1, inorderIdx + 1, end);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}