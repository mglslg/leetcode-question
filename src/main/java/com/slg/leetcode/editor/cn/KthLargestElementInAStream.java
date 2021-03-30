package com.slg.leetcode.editor.cn;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kth = new KthLargestElementInAStream()
                .new KthLargest(3, new int[]{4, 5, 8, 2});

        kth.add(6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
            if (k == root.cnt && root.right == null) {
                return root;
            } else {
                if (k <= subTreeCnt(root.left)) {
                    //cover左子树为空的情况，因为subTreeCnt会为0，而k不会为0
                    return findTarget(root.left, k);
                }else{
                    //因为现在只算从右边几个数里第k大的，所以要减掉左边的，再减掉root的1
                    //subTreeCnt也可以cover左子树为空的情况，左子树为空则只减掉root的1
                    k = k - subTreeCnt(root.left) - 1;
                    return findTarget(root.right, k);
                }
/*
                if (root.left != null && root.right != null) {
                    if (k <= root.left.cnt) {
                        return findTarget(root.left, k);
                    }else{
                        //左子树不为空，减去左子树count再减去根节点的1即可
                        //todo 这里似乎能做优化，判断left是否为空为空就返回0
                        k = k - root.left.cnt - 1;
                        return findTarget(root.right, k);
                    }
                }else if (root.left != null) {
                    return findTarget(root.left, k);
                }else if (root.right != null) {
                    //左子树为空，减去root这个1即可
                    return findTarget(root.right, k - 1);
                }else{
                    //到了叶子节点还不符合开头条件的话，那就是没找到
                    return null;
                }*/
            }
        }

        private int subTreeCnt(KNode child) {
            return child == null ? 0 : child.cnt;
        }

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