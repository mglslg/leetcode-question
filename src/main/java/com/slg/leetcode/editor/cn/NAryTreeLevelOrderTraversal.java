package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：每次完成内层循环之后，队列的大小即为下一行的个数，遍历这个size
     */
    class Solution {
        private LinkedList<Node> queue = new LinkedList();
        List<List<Integer>> rs = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return rs;
            }
            queue.add(root);
            int size = 1;
            while (!queue.isEmpty()) {
                List<Integer> line = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    line.add(curr.val);
                    for (Node child : curr.children) {
                        queue.add(child);
                    }
                }
                rs.add(line);
                size = queue.size();
            }
            return rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}