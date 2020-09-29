package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
        public static void main(String[] args) {
            Solution solution = new BinaryTreeInorderTraversal().new Solution();
            TreeNode node3 = new BinaryTreeInorderTraversal().new TreeNode(3, null, null);
            TreeNode node2 = new BinaryTreeInorderTraversal().new TreeNode(2,node3, null);
            TreeNode root = new BinaryTreeInorderTraversal().new TreeNode(1, null, node2);
            solution.inorderTraversal(root);
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
            /**
             * 思路：根->左->根->左……遍历压栈，因此弹栈时即为左->根->左->根……
             * 其中左可以看作是根，根也可以看作是左，只需要判断这个节点有无右孩子，如果右的话将右孩子当作根重复操作即可
             * 以下为非递归解法(要搞明白什么时候靠push推进程序,什么时候靠pop推进程序)
             *
             * 注意：对于递归来讲重复操作即为重新调用函数,对于非递归程序来说重复操作相当于移动currNode节点
             * 只要发现有左孩子那么就持续移动currNode，一旦移动到最左端，那么currNode就成为当前链条的最后一个元素不再移动，随即开始pop
             * 在pop过程中如果遇到有右孩子的节点，移动currNode到该root节点，重新上面的操作即可
             * 因此currNode在pop时应当始终停留在当前链条的最末端，直到遇到下一个有右孩子的root
             * 所以从本质上讲，就是一个从根节点一路向左的压栈，再从左一路向根弹栈的操作，弹栈期间如果遇到了右孩子则将其当作一个新的根即可！
             */
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> rs = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();

                if (root == null) {
                    return rs;
                }

                //重复动作：1、移动节点 2、入栈 3、一路向左到头之后开始弹栈 4、弹出后判断是否有右孩子 5、如果有右孩子则移动到右孩子开始下一轮
                TreeNode currNode = root;
                stack.push(currNode);
                while (!stack.isEmpty()) {
                    if (currNode.left != null) {//尚有左孩子，持续移动currNode并压栈
                        currNode = currNode.left;
                        stack.push(currNode);
                    }else{//currNode已经是当前链最后一个左孩子,开始弹栈
                        TreeNode popNode = stack.pop();
                        rs.add(popNode.val);
                        if (popNode.right != null) {//弹出当前根之后发现其有右孩子
                            currNode = popNode.right;
                            stack.push(currNode);
                        }
                    }
                }
                return rs;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}