package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：从根节点开始找，小的向左走到root.left，大的向右走到root.right
     * 走不动了就讨论：根-左-右，就在这三个里面往里挤，其中讨论左和右为空的情况即可
     *
     * 也可以理解为二分查找的寻找区间
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode p = root;
            while (true) {
                if (p.left != null && val < p.val) {
                    p = p.left;
                    continue;
                } else if (p.right != null && val > p.val) {
                    p = p.right;
                    continue;
                } else {
                    //左移和右移都已经完成了，现在val就在"根-左-右"这三个数中间，分情况讨论
                    TreeNode newNode = new TreeNode(val);
                    if (val < p.val) {
                        p.left = newNode;
                        if (p.left != null) {
                            //在根、左中间
                            TreeNode left = p.left;
                            p.left = newNode;
                            newNode.left = left;
                        } else {
                            p.left = newNode;
                        }
                    } else {
                        if (p.right != null) {
                            //在根、右中间
                            TreeNode right = p.right;
                            p.right = newNode;
                            newNode.right = right;
                        } else {
                            p.right = newNode;
                        }
                    }

                    //处理完毕退出
                    break;
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}