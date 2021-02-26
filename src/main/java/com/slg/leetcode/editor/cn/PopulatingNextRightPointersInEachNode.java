package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node connect(Node root) {
            Node p = root;
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);

            //todo 哎嘿，挺有意思的啊！

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}