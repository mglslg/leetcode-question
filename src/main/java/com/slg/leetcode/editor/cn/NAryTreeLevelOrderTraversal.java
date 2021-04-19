package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private PriorityQueue<Node> queue = new PriorityQueue();
        List<List<Integer>> rs = new ArrayList<>();
        int levelCount = 1;

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return rs;
            }

            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> currList;
                Node curr = queue.poll();
                if(levelCount==0){
                    currList = new ArrayList<>();
                }
                currList.add(curr.val);
                for (Node child : curr.children) {
                    queue.add(child);
                }
                levelCount--;
            }

            return rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}