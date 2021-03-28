package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 递归思路：一边搜索一边递归构建这棵树
     * 反正也不知怎么写，不如先把递归函数列出来再说吧……结果列出来就会写了
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            //当root为null时上一层一定是个叶子节点，或者本来就是棵空树
            if (root == null) {
                return new TreeNode(val);
            }

            //如果小于root就到左边去重新构建树，如果大于就到右边去重新构建树
            if(val < root.val){
                root.left = insertIntoBST(root.left, val);
            }else{
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}