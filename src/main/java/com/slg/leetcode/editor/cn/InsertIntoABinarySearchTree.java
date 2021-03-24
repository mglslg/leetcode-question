package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路：从根节点开始找，小的向左走到root.left，大的向右走到root.right
     * 之后分两种情况讨论,小于root.left,大于root.left
     * 终止条件：
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode p = root;
            while (true) {
                if (val < p.val) {
                    p = p.left;
                    if(val){

                    }
                }
                if(val > p.val){
                    p = p.right;
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}