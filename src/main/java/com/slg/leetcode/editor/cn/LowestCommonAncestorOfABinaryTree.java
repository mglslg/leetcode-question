package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归解法：f(x)表示当前节点下是否存在p或q
     * (flson && frson) ∣∣ ((x = p ∣∣ x = q) && (flson ∣∣ frson))
     */
    class Solution {
        private TreeNode rs;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            fx(root,p,q);

            return rs;
        }

        private boolean fx(TreeNode curr, TreeNode p, TreeNode q) {
            if (curr == null) {
                return false;
            }
            boolean lAndR = fx(curr.left, p, q) && fx(curr.right, p, q);
            boolean xIsPOrQ = curr == p || curr == q;
            boolean lOrR = fx(curr.left, p, q) || fx(curr.right, p, q);

            if (lAndR || (xIsPOrQ && lOrR)) {
                rs = curr;
            }

            if (curr == p || curr == q) {
                return true;
            }else{
                return (fx(curr.left, p, q) || fx(curr.right, p, q));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}