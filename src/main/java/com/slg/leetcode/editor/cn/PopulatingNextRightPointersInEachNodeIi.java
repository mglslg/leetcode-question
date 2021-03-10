package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 迭代加广度遍历
         * 注意不能只从root.left.left.left出发，并非满二叉树左节点很可能是缺失的
         * 因此需要有一个指针来记录最左端的触发节点
         */
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node mostLeft=root;

            //研究对象：当前节点已经链好了，要准备链下一级的节点
            Node curr;

            while (mostLeft != null) {
                curr = mostLeft;

                while (curr != null) {
                    if (curr.left != null && curr.right != null) {
                        curr.left.next = curr.right;
                        curr.right.next = getNext(curr.next);
                    }
                    if (curr.left != null && curr.right == null) {
                        curr.left.next = getNext(curr.next);
                    }
                    if (curr.left == null && curr.right != null) {
                        curr.right.next = getNext(curr.next);
                    }
                    curr = curr.next;
                }
                mostLeft = getNextLeft(mostLeft);
            }

            return root;
        }

        /**
         * 获取下一个需要链接的节点
         */
        private Node getNext(Node currNode) {
            if (currNode == null) {
                return null;
            }

            while (currNode.left == null && currNode.right == null) {
                currNode = currNode.next;
            }
            if (currNode.left != null) {
                return currNode.left;
            }
            if (currNode.right != null) {
                return currNode.right;
            }

            return null;
        }

        private Node getNextLeft(Node currLeft) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}