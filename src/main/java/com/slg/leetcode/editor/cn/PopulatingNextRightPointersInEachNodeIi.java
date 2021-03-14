package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：不要把它想象成树，就把它想象成一个多层链表，跳表
         * 移动上一层的链表，然后链接下一层的链表，就这样！
         */
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            //研究对象：上一层的链表节点
            Node curr = root;

            while (curr != null) {
                //这个节点相当于一个"钉子"，先把开头钉在墙上，然后让指向它的另一个节点p来移动，一边移动一边串联下一级链表
                Node preNextLevel = new Node(0);
                Node p = preNextLevel;
                while (curr != null) {
                    if (curr.left != null) {
                        p.next = curr.left;
                        p = p.next;
                    }
                    if (curr.right != null) {
                        p.next = curr.right;
                        p = p.next;
                    }
                    curr = curr.next;
                }
                curr = preNextLevel.next;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}