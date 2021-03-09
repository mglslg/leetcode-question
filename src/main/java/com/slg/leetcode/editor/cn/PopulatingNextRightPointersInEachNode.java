package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.Node;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 跳表思路，利用已经建立的root和root.next的关系来构建下一层
     * 一个带链表的广度遍历
     */
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            //left用来记录每行最左端的那个左节点
            Node left = root;

            //curr用来记录平移的那个节点
            Node curr = null;

            //仍有下一行时
            while (left != null) {
                curr = left;

                //平移将节点链起来
                while (curr != null && curr.left!=null) {
                    curr.left.next = curr.right;
                    if (curr.next != null) {
                        curr.right.next = curr.next.left;
                    }

                    //平移到右边一个节点
                    curr = curr.next;
                }

                //移动到下一行
                left = left.left;
            }

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}