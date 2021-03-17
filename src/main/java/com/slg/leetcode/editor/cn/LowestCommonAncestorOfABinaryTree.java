package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 哈希表记录父节点解法：
     * 1、使用一个HashMap记录每个节点的父节点
     * 2、从hashmap中分别找到p和q，依次向上找它俩的父节点，并且还要做记录
     * 3、在向上找的过程中一旦发现父节点在记录中出现过，那这个节点即为最近祖先
     */
    class Solution {
        private HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        private HashSet<TreeNode> path = new HashSet<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            parentMap.put(root,null);

            TreeNode pa = p;
            TreeNode qa = q;

            while (true) {
                if (parentMap.containsKey(pa) || parentMap.containsKey(qa)) {
                    if (parentMap.containsKey(pa)) {
                        if (path.contains(pa)) {
                            return pa;
                        }else{
                            path.add(pa);
                            pa =  parentMap.get(pa);
                        }
                    }
                    if (parentMap.containsKey(qa)) {
                        if (path.contains(qa)) {
                            return qa;
                        }else{
                            path.add(qa);
                            qa = parentMap.get(qa);
                        }
                    }
                }else{
                    return null;
                }
            }
        }

        /**
         * 负责初始化hashmap
         */
        private void dfs(TreeNode root){
            if (root == null) {
                return ;
            }
            if (root.left != null) {
                parentMap.put(root.left, root);
            }
            if (root.right != null) {
                parentMap.put(root.right, root);
            }
            dfs(root.left);
            dfs(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}