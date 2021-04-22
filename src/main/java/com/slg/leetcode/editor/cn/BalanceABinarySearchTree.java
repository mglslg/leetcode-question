package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

import java.util.ArrayList;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new BalanceABinarySearchTree().new Solution();
        Integer[] arry = new Integer[]{1, null, 2, null, 3, null, 4, null, null};
        TreeNode root = UseCaseUtil.buildTree(arry);
        solution.balanceBST(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private ArrayList<Integer> sorted = new ArrayList();

        public TreeNode balanceBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            //先遍历BST，将其变为一个排序数组
            inorder(root);
            //再使用二分法构建BTree
            return getBTree(0, sorted.size() - 1);
        }

        private TreeNode getBTree(int l, int r) {
            if (l > r) {
                return null;
            }
            if (l == r) {
                return new TreeNode(sorted.get(l));
            }
            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(sorted.get(mid));
            root.left = getBTree(l,mid-1);
            root.right = getBTree(mid + 1, r);
            return root;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return ;
            }
            inorder(root.left);
            sorted.add(root.val);
            inorder(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}