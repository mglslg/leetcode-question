package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class BinaryTreePruning{
        public static void main(String[] args) {
                Solution solution = new BinaryTreePruning().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**
             * 91官方题解
             */
            public TreeNode pruneTree(TreeNode root) {
                if (root == null) {
                    return null;
                }
                root.left = pruneTree(root.left);
                root.right = pruneTree(root.right);
                if (isLeaf(root) && root.val == 0) {
                    return null;
                }else{
                    return root;
                }
            }

            boolean isLeaf(TreeNode node) {
                if (node != null && node.left == null && node.right == null) {
                    return true;
                }
                return false;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public TreeNode pruneTree(TreeNode root) {
            //当前为叶子节点且为0，把自己剪了
            if(root.val == 0 && isLeaf(root)){
                return null;
            }

            //进入左右孩子递归
            if(root.left!=null){
                root.left = pruneTree(root.left);
            }
            if (root.right != null) {
                root.right = pruneTree(root.right);
            }

            //最顶层递归判断左右孩子情况
            if (isLeaf(root.left) && root.left.val == 0) {
                root.left = null;
            }
            if (isLeaf(root.right) && root.right.val == 0) {
                root.right = null;
            }
            if (isLeaf(root) && root.val == 0) {
                return null;
            }
            return root;
        }

        boolean isLeaf(TreeNode node) {
            if (node != null && node.left == null && node.right == null) {
                return true;
            }
            return false;
        }
    }
}