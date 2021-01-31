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
        private int lastLeftEnd = 0;//用于记录当前最左孩子的索引,下一个元素即当前根节点的右孩子

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderList = preorder;
            inorderList = inorder;
            if (preorder.length == 0) {
                return null;
            }
            return getTree(0, 0, inorder.length - 1);
        }

        /**
         * 本质上是个用根节点在树里做二分查找的过程
         * 考虑用map存值map<value,index> 然后空间换时间？
         * @param currRootIdx 根节点在先序遍历中的位置
         * @param startIdx    区间开始索引在中序遍历中的位置
         * @param endIdx      区间结束索引在中序遍历中的位置
         */
        private TreeNode getTree(int currRootIdx, int startIdx, int endIdx) {
            //某个节点的左孩子或右孩子为空
            if (startIdx > endIdx) {
                return null;
            }

            int rootVal = preorderList[currRootIdx];
            TreeNode root = new TreeNode();
            root.val = rootVal;

            for (int i = startIdx; i <= endIdx; i++) {
                if (inorderList[i] == rootVal) {
                    root.left = getTree(currRootIdx + 1, startIdx, i - 1);
                    if (root.left == null) {
                        //说明当前节点已经是最左的节点,那么lastLeftEnd+1就应当是当前节点的右孩子
                        lastLeftEnd = currRootIdx;
                    }
                    root.right = getTree(lastLeftEnd + 1, i + 1, endIdx);
                }
            }

            return root;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}