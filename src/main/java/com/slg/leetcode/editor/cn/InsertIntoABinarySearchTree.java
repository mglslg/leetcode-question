package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：从根节点开始找，小的向左走到root.left，大的向右走到root.right
     * 终止条件肯定是这样：根-左-右，就在这三个里面往里挤，其中讨论左和右为空的情况即可
     * 也可以理解为二分查找的寻找区间
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode p = root;
            while (true) {
                if (val < p.val) {
                    //此时p是最后一个大于val的左节点
                    p = moveLeft(p, val);
                    if (p.left == null && p.right == null) {
                        //已经是最小节点，直接拼到左孩子
                        TreeNode newNode = new TreeNode(val);
                        p.left = newNode;
                        break;
                    }else{
                        if(){

                        }
                    }
                }else{
                    p = moveRight(p, val);
                }
            }
            return root;
        }

        /**
         * 返回最后一个大于val的左节点pre,val的值介于pre和pre.left之间
         */
        private TreeNode moveLeft(TreeNode node, int val) {
            TreeNode pre = node;
            TreeNode p = node.left;
            while (p != null && val < p.val) {
                pre = p;
                p = p.left;
            }
            return pre;
        }

        /**
         * 返回最后一个小于val的右节点pre,val的值介于pre和pre.right之间
         */
        private TreeNode moveRight(TreeNode node, int val) {
            TreeNode pre = node;
            TreeNode p = node.right;
            while (p != null && val > p.val) {
                pre = p;
                p = p.right;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}