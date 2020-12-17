package com.slg.leetcode.editor.cn;

public class FriendCircles{
        public static void main(String[] args) {
                Solution solution = new FriendCircles().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            private int[] parents = null;
            private int count = 0;
            public int findCircleNum(int[][] M) {
                count = M.length;
                parents = makeSet(M.length);
                for (int i = 0; i < M.length; i++) {
                    for (int j = 0; j < M[i].length; j++) {
                        if (M[i][j] == 1) {
                            //如果两人有边，尝试合并
                            union(i,j);
                        }
                    }
                }
                return count;
            }

            //初始化将每一个节点的父节点指为自己
            private int[] makeSet(int length){
                parents = new int[length];
                for (int i = 0; i < length; i++) {
                    parents[i] = i;
                }
                return parents;
            }

            private int findRoot(int node) {
                if (node != parents[node]) {
                    //这里加入了压缩的逻辑！将当前节点指向根！
                    return parents[node] = findRoot(parents[node]);
                }else {
                    return node;
                }
            }

            private void union(int x, int y) {
                if (findRoot(x) == findRoot(y)) {
                    return ;
                }
                parents[parents[x]] = parents[y];
                count--;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}