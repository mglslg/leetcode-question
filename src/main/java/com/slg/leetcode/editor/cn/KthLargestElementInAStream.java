package com.slg.leetcode.editor.cn;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kth = new KthLargestElementInAStream()
                .new KthLargest(3, new int[]{4, 5, 8, 2});

        kth.add(6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        private KNode kRoot;

        public KthLargest(int k, int[] nums) {
            //这里构造bst，cnt应该是可以直接递归更新，看看怎么写
            kRoot = new KNode(nums[0]);
            kRoot.cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                kRoot = addNodeToBST(kRoot, nums[i]);
            }
        }

        public int add(int val) {
            kRoot = addNodeToBST(kRoot, val);

            return -1;
        }
    }

    private KNode addNodeToBST(KNode root, int val) {
        if (root == null) {
            KNode leaf = new KNode(val);
            leaf.cnt = 1;
            return leaf;
        }
        if (val < root.val) {
            root.left = addNodeToBST(root.left, val);
        } else {
            root.right = addNodeToBST(root.right, val);
        }
        root.cnt = (root.left == null ? 0 : root.left.cnt) + (root.right == null ? 0 : root.right.cnt);
        return root;
    }

    private class KNode {
        private int val;
        private KNode left;
        private KNode right;
        private int cnt;

        private KNode() {
        }

        private KNode(int _val) {
            val = _val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}