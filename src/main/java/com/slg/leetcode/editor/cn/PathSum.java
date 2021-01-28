package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //递归解法,每次遇到叶子节点时计算通路的值,看是否相等
    //注意判断叶子节点的部分不能用root==null来判断，必须使用leftChild和rightChild，因为为空并不能代表是叶子节点！
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                if (targetSum == 0) {
                    return true;
                }
                return false;
            }
            return equalsSum(root, 0, targetSum);
        }

        //node不接受空值
        private boolean equalsSum(TreeNode node, int sum, int targetSum) {
            //叶子节点
            if (node.left == null && node.right == null) {
                if (sum + node.val == targetSum) {
                    return true;
                }
                return false;
            }
            //只有右孩子
            if (node.left == null) {
                return equalsSum(node.right, node.val + sum, targetSum);
            }
            //只有左孩子
            if (node.right == null) {
                return equalsSum(node.left, node.val + sum, targetSum);
            }
            //既有左孩子又有右孩子
            return equalsSum(node.left, node.val + sum, targetSum)
                    || equalsSum(node.right, node.val + sum, targetSum);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}