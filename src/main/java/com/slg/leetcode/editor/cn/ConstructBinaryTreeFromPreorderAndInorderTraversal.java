package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> inorderMap = new HashMap<>();
        private int[] preorderList = null;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null) {
                return null;
            }
            preorderList = preorder;
            if (preorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            return treeHelper(0, 0, inorder.length - 1);
        }

        private TreeNode treeHelper(int rootIdx, int inorderStartIdx, int inorderEndIdx) {
            //下面的两个判断条件还需要仔细研究研究
            if (rootIdx >= preorderList.length) {
                return null;
            }
            if (inorderStartIdx > inorderEndIdx) {
                return null;
            }

            int rootVal = preorderList[rootIdx];
            TreeNode root = new TreeNode();
            root.val = rootVal;

            int inorderRootIdx = inorderMap.get(rootVal);
            root.left = treeHelper(rootIdx + 1, inorderStartIdx, inorderRootIdx - 1);
            root.right = treeHelper(rootIdx + (inorderRootIdx - inorderStartIdx) + 1, inorderRootIdx + 1, inorderEndIdx);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}