package com.slg.leetcode.editor.cn;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kth = new KthLargestElementInAStream()
                .new KthLargest(3, new int[]{4, 5, 8, 2});

        kth.add(3);
        kth.add(5);
        kth.add(10);
        kth.add(9);
        kth.add(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：构建一颗BST，第k大的元素即为排序数列中的第 length-k+1 个数
     * 数左子树就是第m个数；数右子树就是第k大的。CntRoot=CntLeft+CntRight+1
     * 其中length即为根节点的cnt值
     *
     * 但是这种解法目前解决不了重复数值的问题，可以考虑用一个map来记录重复值，然后每发现一次就令m+1或者k+1,之后继续找
     * 因此这题还需要继续优化
     */
    class KthLargest {
        private int k;
        private KNode kRoot;

        public KthLargest(int k, int[] nums) {
            this.k = k;

            //这里构造bst，cnt应该是可以直接递归更新，看看怎么写
            kRoot = new KNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                kRoot = addNodeToBST(kRoot, nums[i]);
            }
        }

        public int add(int val) {
            kRoot = addNodeToBST(kRoot, val);
            KNode target = findTarget(kRoot, this.k);
            return target.val;
        }

        public KNode findTarget(KNode root, int k) {
            //数列中的第m个值
            int m = root.cnt - k + 1;

            /**
             * 左子树cnt+1代表第m个元素
             * 右子树cnt就代表k+1就代表第k大
             */
            if ((root.cnt - subTreeCnt(root.right) == m)
                    || (root.cnt - subTreeCnt(root.left) == k)) {
                return root;
            }else{
                if (m <= subTreeCnt(root.left)) {
                    return findTarget(root.left, k);
                } else {
                    return findTarget(root.right, k);
                }
            }
        }

        //可以cover子树为空的情况，可不判断左右孩子是否为null而直接使用
        private int subTreeCnt(KNode child) {
            return child == null ? 0 : child.cnt;
        }

        //这棵树所有重复的值都在右侧
        private KNode addNodeToBST(KNode root, int val) {
            if (root == null) {
                KNode leaf = new KNode(val);
                leaf.cnt = 1;
                return leaf;
            }
            if (val < root.val) {
                //左子树一定是小于的
                root.left = addNodeToBST(root.left, val);
            } else {
                //右子树有可能有等于的值
                root.right = addNodeToBST(root.right, val);
            }

            //注意一定得记得这个1，加上自己！加上自己！加上自己！
            root.cnt = 1 + (root.left == null ? 0 : root.left.cnt) + (root.right == null ? 0 : root.right.cnt);
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
    }
    //leetcode submit region end(Prohibit modification and deletion)

}