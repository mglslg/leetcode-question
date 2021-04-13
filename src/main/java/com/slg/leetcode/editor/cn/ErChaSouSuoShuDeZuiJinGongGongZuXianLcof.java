package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {

    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 找见一个节点，这个节点刚好比p大，比q小
     * 如果root小于p并且小于q,说明pq在root的右侧，那么就移动到右子树；反之移动到左子树
     */
    class Solution {
        private TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}