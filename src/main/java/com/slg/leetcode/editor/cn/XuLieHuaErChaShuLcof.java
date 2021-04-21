package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.LinkedList;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        //System.out.println(solution.serialize(root));

        String nodes = "[1,2,3,5,null,null,6,null,null,7,8]";
        TreeNode rs = solution.deserialize(nodes);
        System.out.println(rs.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer rs = new StringBuffer();
            LinkedList<TreeNode> queue = new LinkedList<>();
            rs.append("[");
            if (root == null) {
                return rs.append("]").toString();
            }
            queue.add(root);
            TreeNode latestAddNode = root;
            while (!queue.isEmpty()) {
                TreeNode curr = queue.pollFirst();
                if (curr == null) {
                    rs.append("null,");
                } else {
                    rs.append(curr.val + ",");
                    queue.add(curr.left);
                    if (curr.left != null) {
                        latestAddNode = curr.left;
                    }
                    queue.add(curr.right);
                    if (curr.right != null) {
                        latestAddNode = curr.right;
                    }
                }
                if (curr == latestAddNode) {
                    //当当前出队节点就是最近入队节点时，说明此时队列中再无非空节点，循环终止
                    break;
                }
            }

            //使用右方括号替换调最后一个多出来的逗号
            rs.setCharAt(rs.length() - 1, ']');
            return rs.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            String nodeStr = data.substring(1, data.length() - 1);
            String[] nodes = nodeStr.split(",");
            TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
            queue.add(root);
            for (int i = 1; i < nodes.length; i=i+2) {
                TreeNode curr = queue.poll();
                if(!"null".equals(nodes[i])){
                    curr.left = new TreeNode(Integer.valueOf(nodes[i]));
                    queue.add(curr.left);
                }
                if(i+1<nodes.length && !"null".equals(nodes[i+1])){
                    curr.right = new TreeNode(Integer.valueOf(nodes[i+1]));
                    queue.add(curr.right);
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}