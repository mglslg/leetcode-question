package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] preorderList = null;
        private int[] inorderList = null;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderList = preorder;
            inorderList = inorder;
            if (preorder.length == 0) {
                return null;
            }
            return getTree(0, 0, inorder.length - 1);
        }

        private TreeNode getTree(int currRootIdx, int startIdx, int endIdx) {
            int rootVal=preorderList[currRootIdx];
            TreeNode root = new TreeNode();
            root.val = rootVal;

            for (int i = startIdx; i <= endIdx; i++) {
                if (inorderList[i] == rootVal) {
                    if (i - 1 >= startIdx) {
                        root.left = getTree(currRootIdx+1, startIdx, i - 1);
                    }else{
                        //已经向左走到头了，该右边了
                        if (endIdx >= i + 1) {
                            //右侧至少还剩一个，连到右孩子上
                            root.right = getTree(currRootIdx+1, i + 1, endIdx);
                        }
                    }
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}