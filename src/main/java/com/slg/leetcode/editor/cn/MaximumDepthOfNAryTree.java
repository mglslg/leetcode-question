package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = 0;
        int stackLength = 0;

        public int maxDepth(Node root) {
            helper(root);
            return max;
        }

        private void helper(Node root) {
            if (root == null) {
                return ;
            }
            stackLength++;
            if (stackLength > max) {
                max = stackLength;
            }
            for (Node child : root.children) {
                helper(child);
            }
            stackLength--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}