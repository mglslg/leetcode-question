package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
        public static void main(String[] args) {
                Solution solution = new BinaryTreePreorderTraversal().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        public class TreeNode {
              int val;
              TreeNode left;
              TreeNode right;
              TreeNode() {}
              TreeNode(int val) { this.val = val; }
              TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
              }
        }
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) {
                Stack<TreeNode> stack = new Stack<>();
                List<Integer> rs = new ArrayList<>();

                TreeNode currNode = root;
                if(root!=null){
                    stack.push(root);
                    rs.add(root.val);
                }else{
                    return rs;
                }

                while (!stack.isEmpty()) {
                    if (currNode.left != null) {
                        stack.push(currNode.left);
                        rs.add(currNode.left.val);
                        currNode = currNode.left;
                    }else{
                        TreeNode popNode = stack.pop();
                        if (popNode.right != null) {
                            currNode = popNode.right;
                            stack.push(currNode);
                            rs.add(currNode.val);
                        }
                    }
                }

                return rs;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)

}