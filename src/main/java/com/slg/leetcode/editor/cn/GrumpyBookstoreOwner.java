package com.slg.leetcode.editor.cn;

import java.util.LinkedList;


public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new GrumpyBookstoreOwner().new Solution();
        int[] custo = new int[]{10, 4};
        int[] gru = new int[]{0, 1};
        solution.maxSatisfied(custo, gru, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            //先找出不使用憋气技能的人数最大值
            int originalMax = 0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    originalMax = originalMax + customers[i];
                }
            }
            //不生气时能扳回的人数最大值
            int deltaMax = 0;
            int deltaIdx = 0;
            int currWindow = 0;
            LinkedList<Integer> window = new LinkedList<>();
            for (int i = 0; i < customers.length; i++) {
                //构造窗口
                if (i < X) {
                    window.addLast(i);
                    if (grumpy[i] == 1) {
                        currWindow = currWindow + customers[i];
                        deltaMax = currWindow;
                    }
                }else{
                    //新元素准备进入窗口
                    if (grumpy[window.peekFirst()] == 1) {
                        currWindow = currWindow - customers[window.peekFirst()];
                    }
                    if (grumpy[i] == 1) {
                        currWindow = currWindow + customers[i];
                    }
                    window.pollFirst();
                    window.addLast(i);
                    if (currWindow > deltaMax) {
                        deltaMax = currWindow;
                        deltaIdx = window.peekFirst();
                    }
                }
            }
            System.out.println("idx:" + deltaIdx);
            return originalMax + deltaMax;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}