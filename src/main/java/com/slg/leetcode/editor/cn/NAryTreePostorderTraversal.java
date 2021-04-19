package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> postorder(Node root) {
            helper(root);
            return result;
        }

        private void helper(Node root) {
            if (root == null) {
                return;
            }
            for (Node child : root.children) {
                helper(child);
            }
            result.add(root.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}