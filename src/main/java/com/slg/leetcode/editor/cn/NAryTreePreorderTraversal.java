package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> preorder(Node root) {
            traverse(root);
            return result;
        }

        private void traverse(Node root) {
            if (root == null) {
                return ;
            }
            result.add(root.val);
            for (Node child : root.children) {
                traverse(child);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}