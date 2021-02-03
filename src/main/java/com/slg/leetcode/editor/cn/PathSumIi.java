package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;
import com.slg.leetcode.editor.cn.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        Integer[] tree = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = UseCaseUtil.buildTree(tree);
        solution.pathSum(root, 22);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> pathList = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            LinkedList<Integer> pathRem = new LinkedList<>();
            getSum(targetSum, root, pathRem);
            return pathList;
        }

        private void getSum(int currSum, TreeNode node,LinkedList<Integer> pathRem) {
            if (node == null) {
                return ;
            }

            pathRem.add(node.val);

            if (node.left == null && node.right == null) {
                if (currSum == node.val) {
                    //满足条件的
                    List<Integer> path = new ArrayList<>();
                    pathRem.stream().forEach(r -> path.add(r));
                    pathList.add(path);
                }
            }else{
                getSum(currSum - node.val, node.left, pathRem);
                getSum(currSum - node.val, node.right, pathRem);
            }
            //不论是不是叶子节点return之前都要先把队列的最后一位弹出去
            pathRem.pollLast();
            return ;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}