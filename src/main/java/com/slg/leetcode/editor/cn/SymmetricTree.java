package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(null);
        System.out.println(queue);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //BFS,广度优先不一定要顺序存放节点，也可以一对一对的玩出花样来
    //本题就是先按照将来要比较的顺序成对将其放入队列，然后再成对取出比较即可
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            LinkedList<TreeNode> queue = new LinkedList();
            queue.add(root.left);
            queue.add(root.right);

            while (!queue.isEmpty()) {
                //每次出队一对儿
                TreeNode leftSideP = queue.poll();
                TreeNode rightSideP = queue.poll();

                if (!checkEquals(leftSideP, rightSideP)) {
                    return false;
                }
                if (leftSideP != null && rightSideP != null) {
                    queue.add(leftSideP.left);
                    queue.add(rightSideP.right);
                    queue.add(leftSideP.right);
                    queue.add(rightSideP.left);
                }
            }
            return true;
        }

        boolean checkEquals(TreeNode node1, TreeNode node2) {
            if (node1 != null && node2 == null) {
                return false;
            }
            if(node1 == null && node2 != null){
                return false;
            }
            if(node1 != null && node2 != null && node1.val != node2.val){
                return false;
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    //递归解法
    class Solution1 {
        private TreeNode currLeftSideNode;

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return recursiveCheckEqual(root.left, root.right);
        }

        boolean recursiveCheckEqual(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 != null && node2 != null) {
                if (node1.val == node2.val
                        && recursiveCheckEqual(node1.left, node2.right)
                        && recursiveCheckEqual(node1.right, node2.left)) {
                    return true;
                }
            }
            return false;
        }
    }

    //迭代解法
    class Solution2 {
        private TreeNode currLeftSideNode;

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            Stack<TreeNode> leftStack = new Stack<>();
            Stack<TreeNode> rightStack = new Stack<>();
            TreeNode leftP = root.left;
            TreeNode rightP = root.right;
            leftStack.push(leftP);
            rightStack.push(rightP);

            while(!leftStack.isEmpty()){
                //这条件判断真是日了狗
                if (!checkEquals(leftP, rightP)) {
                    return false;
                }

                //两侧都不为空(只判断一边即可),两边不相同的话上面就返回false了
                if (leftP != null) {
                    //左边往左走，右边往右走
                    leftP = leftP.left;
                    rightP = rightP.right;
                    if (leftP != null && rightP != null) {
                        leftStack.push(leftP);
                        rightStack.push(rightP);
                    }
                }else{
                    //两侧都为空,从栈中弹出当前父节点，然后左边往右走，右边往左走
                    leftP = leftStack.pop().right;
                    rightP = rightStack.pop().left;
                    if (leftP != null && rightP != null) {
                        leftStack.push(leftP);
                        rightStack.push(rightP);
                    }
                }
            }
            return checkEquals(leftP,rightP);
        }

        boolean checkEquals(TreeNode node1, TreeNode node2) {
            if (node1 != null && node2 == null) {
                return false;
            }
            if(node1 == null && node2 != null){
                return false;
            }
            if(node1 != null && node2 != null && node1.val != node2.val){
                return false;
            }
            return true;
        }
    }
}