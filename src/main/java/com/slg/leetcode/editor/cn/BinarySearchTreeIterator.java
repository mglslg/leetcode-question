package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路：用一个栈来记录中序遍历的路径，弹出的顺序就是排序的顺序
     */
    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushIntoStack(root);
        }

        public int next() {
            TreeNode currNode = stack.pop();
            if (currNode.right != null) {
                //说明是某个根
                pushIntoStack(currNode.right);
            }else{
                //说明只是个左孩子,什么都不做
            }
            return currNode.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * 用于将某个节点下的左孩子-根-左孩子-根……全部push到栈中
         * 栈顶的元素都有两种可能性:左孩子or根
         * @param node
         */
        private void pushIntoStack(TreeNode node) {
            TreeNode p = node;
            while (true) {
                stack.push(p);
                if (p.left != null) {
                    p = p.left;
                }else{
                    break;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}