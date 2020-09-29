package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal{
        public static void main(String[] args) {
            Solution solution = new BinaryTreePostorderTraversal().new Solution();
            TreeNode node3 = new BinaryTreePostorderTraversal().new TreeNode(3, null, null);
            TreeNode node2 = new BinaryTreePostorderTraversal().new TreeNode(2,node3, null);
            TreeNode root = new BinaryTreePostorderTraversal().new TreeNode(1, null, node2);
            solution.postorderTraversal(root);
        }

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

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public List<Integer> postorderTraversal(TreeNode root) {
                Stack<TreeNode> stack = new Stack<>();
                List<Integer> rs = new ArrayList<>();

                //用于记录已经pop过一次的友孩子，防止"根->右->根->右"的死循环
                TreeNode rem = null;

                TreeNode currNode = root;

                if(root!=null){
                    stack.push(root);
                }else{
                    return rs;
                }

                while (!stack.isEmpty()) {
                    if (currNode.left != null) {
                        currNode = currNode.left;
                        stack.push(currNode);
                    }else{
                        TreeNode peekNode = stack.peek();
                        if (peekNode.right != null && peekNode.right!=rem) {
                            currNode = peekNode.right;
                            stack.push(currNode);
                        }else{
                            TreeNode popNode = stack.pop();
                            rs.add(popNode.val);
                            rem = popNode;
                        }
                    }
                }

                return rs;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}