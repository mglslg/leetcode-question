package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：广度遍历加上一个记录层级的变量,行末加入null,然后依次connect即可
     */
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            int level = 0;
            int count = 1;

            while (!queue.isEmpty()) {
                if (count == 0) {
                    //到了行末,进入下一行
                    queue.add(null);
                    level++;
                    count = (int) Math.pow(2, level);
                } else {
                    Node curr = queue.pollFirst();
                    if (curr == null) {
                        //上一行的最后一个null值,直接跳过
                        continue;
                    }
                    curr.next = queue.peekFirst();
                    //不为叶子节点
                    if (curr.left != null) {
                        queue.add(curr.left);
                        queue.add(curr.right);
                    }
                    count--;
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}