package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;
import java.util.Stack;

public class ErChaShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：在递归遍历二叉树时使用一个tempStack来记录函数的递归栈
     * 当找到p或者q的时候，将这个stack复制出来分别放到pStack和qStack中
     * 之后开始比较两个栈的元素情况，最后一个重合的节点即为公共节点！
     * 可以先比较两个栈的长度，然后让长一点的那个先pop，
     * pop到长度相等的时候两个一起pop，之后只要遇到一个相同的元素就是最近公共祖先！
     */
    class Solution {
        private Stack<TreeNode> pStack;
        private Stack<TreeNode> qStack;
        private Stack<TreeNode> currStack = new Stack<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            stackHelper(root, p, q);
            while (pStack.size() > qStack.size()) {
                pStack.pop();
            }
            while (qStack.size() > pStack.size()) {
                qStack.pop();
            }
            while (!qStack.isEmpty()) {
                TreeNode currQ = qStack.pop();
                TreeNode currP = pStack.pop();
                if (currQ.val == currP.val) {
                    return currQ;
                }
            }
            return null;
        }

        private void stackHelper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return;
            }
            currStack.push(root);
            if (root.val == p.val) {
                pStack = (Stack<TreeNode>)currStack.clone();
            }
            if (root.val == q.val) {
                qStack = (Stack<TreeNode>) currStack.clone();
            }
            stackHelper(root.left, p, q);
            stackHelper(root.right, p, q);
            currStack.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}