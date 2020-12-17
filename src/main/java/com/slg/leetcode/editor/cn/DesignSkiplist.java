package com.slg.leetcode.editor.cn;

import java.util.Random;

public class DesignSkiplist{
        public static void main(String[] args) {
            Skiplist solution = new DesignSkiplist().new Skiplist();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Skiplist {
            Node head = new Node(null, null, 0);
            public boolean search(int target) {
                for (Node p = head; p != null; p = p.down) {
                    while (p.right != null && p.right.val < target) {
                        p = p.right;
                    }
                    if (p.right != null && p.right.val == target) {
                        return true;
                    }
                }
                return false;
            }

            //insert时用来记录每一层的currNode
            Node[] stack = new Node[64];
            public void add(int num) {
                int lv = -1;
                for (Node p = head; p != null; p = p.down) {
                    while (p.right != null && p.right.val < num) {
                        p = p.right;
                    }
                    stack[++lv] = p;
                }
                boolean insertUp = true;
                Node downNode = null;
                while (insertUp && lv >= 0) {
                    Node insert = stack[lv--];
                    insert.right = new Node(insert.right, downNode, num);
                    downNode = insert.right;
                    //随机数与1做与运算，得出0或1，每次有50%的概率在上一层添加节点
                    Random rand = new Random();
                    insertUp = (rand.nextInt() & 1) == 0;
                }
                if (insertUp) {
                    head = new Node(new Node(null, downNode, num), head, 0);
                }
            }

            public boolean erase(int num) {
                boolean exists = false;
                for (Node p = head; p != null; p = p.down) {
                    while (p.right != null && p.right.val < num) {
                        p = p.right;
                    }
                    if (p.right != null && p.right.val <= num) {
                        exists = true;
                        p.right = p.right.right;
                    }
                }
                return exists;
            }

            private class Node {
                int val;
                Node right, down;

                public Node(Node r, Node d, int val) {
                    right = r;
                    down = d;
                    this.val = val;
                }
            }
        }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)
class Skiplist1 {
    private class Node{
        int level = 0;
        int value = 0;
        Node next = null;
        Node down = null;
    }

    public Skiplist1() {

    }

    public boolean search(int target) {
        return false;
    }

    public void add(int num) {

    }

    public boolean erase(int num) {
        return false;
    }
}
}