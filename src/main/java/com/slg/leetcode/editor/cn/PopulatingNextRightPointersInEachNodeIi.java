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
         * 因此需要有一个指针来记录最左端的触发节点(下一代长子)
         */
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            //每一代的长子
            Node eldestSon = root;

            //研究对象：当前节点已经链好了，要准备链下一代的节点
            Node curr;

            while(eldestSon != null){
                //从长子开始对其下一代进行链接
                curr = eldestSon;
                while (curr != null) {
                    if (curr.left != null && curr.right != null) {
                        curr.left.next = curr.right;
                        curr.right.next = getCurrEldestChild(curr.next);
                    }
                    if (curr.left != null && curr.right == null) {
                        curr.left.next = getCurrEldestChild(curr.next);
                    }
                    if (curr.left == null && curr.right != null) {
                        curr.right.next = getCurrEldestChild(curr.next);
                    }
                    curr = curr.next;
                }

                eldestSon = getCurrEldestChild(eldestSon);
            }

            return root;
        }

        /**
         * 获取从当前节点开始数起的第一个孩子
         */
        private Node getCurrEldestChild(Node currNode) {
            if (currNode == null) {
                return null;
            }

            while (currNode!=null && currNode.left == null && currNode.right == null) {
                currNode = currNode.next;
            }
            if (currNode!=null && currNode.left != null) {
                return currNode.left;
            }
            if (currNode!=null && currNode.right != null) {
                return currNode.right;
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}