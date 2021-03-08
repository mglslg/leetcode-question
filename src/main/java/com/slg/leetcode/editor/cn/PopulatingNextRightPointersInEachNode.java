package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 跳表思路，利用已经建立的root和root.next的关系来构建下一层
     */
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                //这个解法的问题在于只解决了左半边的问题，没有向右平移！
                Node connectedLeft = connect(root.left);
                Node connectedRight = connect(root.right);
                connectedLeft.next = connectedRight;
                if (root.next != null) {
                    connectedRight.next = root.next.left;
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}