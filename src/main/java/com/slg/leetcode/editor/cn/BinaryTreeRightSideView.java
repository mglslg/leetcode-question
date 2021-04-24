package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：其实就是打印每一层最右边的节点
     * 具体写法与N叉树的层序遍历很类似
     */
    class Solution {
        LinkedList<TreeNode> queue=new LinkedList();
        List<Integer> rs = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return rs;
            }

            queue.add(root);
            //用于记录当前行的节点总数
            int count = queue.size();

            while (!queue.isEmpty()) {
                while (count > 0) {
                    TreeNode curr = queue.pollFirst();
                    if (count == 1) {
                        //某行最后一个节点
                        rs.add(curr.val);
                    }
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                    count--;
                }
                count = queue.size();
            }

            return rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}