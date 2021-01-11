package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);

        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode root = new TreeNode(3, node9, node20);

        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        solution.maxDepth(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 用一个stack记录遍历的节点，stack的最大值即为深度
     * 采用后序遍历，因为只有后序遍历才能保证stack有完整的深度
     *
     * 注意：
     * 1、后序遍历必须得记录上一次pop的右孩子防止进入死循环
     * 2、谨慎修改指针p，防止进入死循环
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int deep = 1;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode p = root;
            TreeNode lastPop = null;
            while (!stack.isEmpty()) {
                if (p.left != null) {
                    stack.push(p.left);
                    deep = stack.size() > deep ? stack.size() : deep;
                    p = p.left;
                } else{
                    TreeNode peek = stack.peek();
                    if (peek.right != null && peek.right != lastPop) {
                        stack.push(peek.right);
                        deep = stack.size() > deep ? stack.size() : deep;
                        p = peek.right;
                    } else {
                        lastPop = stack.pop();
                    }
                }
            }
            return deep;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归法
     * 思路：二叉树嘛，其实关键是要从左右节点上面找幺蛾子！那样是最优雅的思路！
     * 我们只考虑(根-左-右)三个节点，这样的话想知道根的高度只要知道左右节点哪个高度更大就好了!
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            if (root != null) {
                int leftMax = maxDepth(root.left);
                int rightMax = maxDepth(root.right);
                return leftMax > rightMax ? leftMax + 1 : rightMax + 1;
            } else {
                return 0;
            }
        }
    }
}