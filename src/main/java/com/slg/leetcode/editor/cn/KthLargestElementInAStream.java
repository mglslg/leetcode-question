package com.slg.leetcode.editor.cn;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {

        public KthLargest(int k, int[] nums) {
            //这里构造bst，cnt应该是可以直接递归更新，看看怎么写
        }

        public int add(int val) {

            return -1;
        }
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