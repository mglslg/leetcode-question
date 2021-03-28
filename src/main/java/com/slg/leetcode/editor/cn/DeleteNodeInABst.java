package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路：本质就是找到二叉树中序遍历的【前驱结点】或【后继节点】，用其替代被删节点
     * 前驱结点：predecessor、后继节点：successor
     * 1、如果被删节点已经是叶子节点，那么直接将其指向null即可
     * 2、如果被删节点只有一个孩子，那么不管是左孩子还是右孩子，都肯定可以继承老爹的"遗志"(符合BST特性)，所以直接替掉老爹即可
     * 3、如果被删节点有俩孩子那么就会有点麻烦，因为只能选一边来继承"遗志"，这时就需要考虑前驱节点和后继节点了，使用前驱或后继节点来替换掉被删节点即可
     * <p>
     * BST的形状并不唯一，只要满足条件的都算，只要你乐意可以把它弄成一个链表(全部都是左孩子，深度为n)
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return root;
            }
            if (key == root.val) {
                if (root.right == null || root.left == null) {
                    //只要有一方为空就返回另一方即可(相当于用左右孩子替换了当前节点)，可以同时cover均为空的情况
                    return root.right == null ? root.left : root.right;
                }else{
                    //有俩孩子,找到前驱节点(左子树的最右孩子)
                    TreeNode predecessor = root.left;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    int predecessorVal = predecessor.val;
                    root = deleteNode(root, predecessorVal);//啊呀！这个地方真的很巧妙哎！因为predecessor一定是个叶子节点，所以就会走叶子节点的删除方案！
                    root.val = predecessorVal;

                    //predecessor.left = root.left;
                    //todo 怎样才能断掉predecessor跟他爹的链接呢 ？
                    //return predecessor;
                }
            }
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
                return root;
            } else {
                root.right = deleteNode(root.right, key);
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}