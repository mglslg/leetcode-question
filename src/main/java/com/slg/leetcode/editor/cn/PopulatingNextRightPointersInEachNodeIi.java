package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这题用递归写法不好做！因为是一个广度遍历
         */
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right != null ? root.right : (root.next != null ? (root.next.left != null ? root.next.left : root.next.right) : null);
                if (root.right != null) {
                    root.right.next=root.next!=null?(root.next.left!=null?root.next.left:(root.next.right)):null;
                }
            }
            if (root.right != null) {
                root.right.next=root.next!=null?(root.next.left!=null?root.next.left:(root.next.right)):null;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}