package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.LinkedList;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode root=new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(solution.serialize(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {
        StringBuffer rs = new StringBuffer();
        LinkedList<TreeNode> queue = new LinkedList<>();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            rs.append("[");
            if (root == null) {
                return rs.append("]").toString();
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.pollFirst();
                if (curr == null) {
                    rs.append("null,");
                }else{
                    rs.append(curr.val + ",");
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }

            //使用右方括号替换调最后一个多出来的逗号
            rs.setCharAt(rs.length() - 1, ']');
            return rs.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}