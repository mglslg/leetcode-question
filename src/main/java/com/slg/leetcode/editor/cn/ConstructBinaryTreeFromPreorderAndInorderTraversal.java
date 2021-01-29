package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
            int currVal=preorderList[currRootIdx];
            TreeNode root = new TreeNode();
            root.val = currVal;

            for (int i = startIdx; i <= endIdx; i++) {
                if (inorderList[i] == currVal) {
                    if (i - 1 >= startIdx) {
                        root.left = getTree(currRootIdx++, startIdx, i - 1);
                    }else{
                        //已经向左走到头了，该右边了
                        if (endIdx >= i + 1) {
                            //右侧至少还剩一个，连到右孩子上
                            root.right = getTree(currRootIdx++, i + 1, endIdx);
                        }
                    }
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}