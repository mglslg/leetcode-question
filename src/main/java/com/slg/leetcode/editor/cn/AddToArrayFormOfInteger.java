package com.slg.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        System.out.println(solution.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 先前试图抖机灵将数组转换为数字然后加k再转回来
     * 结果分分钟被测试用例[9,9,9,9,9,9,9,9,9,9]教做人
     * 数组越界，只能乖乖按位相加了哎~~~
     * 技巧：线性表从左向右增长使用Array，从右向左增长使用LinkedList::addFirst
     * 这样就不必使用stack倒来倒去
     */
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            if (num.length == 0) {
                return numToList(k);
            }
            LinkedList<Integer> result = new LinkedList<>();
            int carry = 0;
            int size = num.length;
            LinkedList<Integer> kNum = numToList(k);
            while (!kNum.isEmpty() || size > 0) {
                //注意这里的条件判断优化办法
                int x = kNum.isEmpty()?0:kNum.pollLast();
                int y = size > 0 ? num[size - 1] : 0;

                result.addFirst((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
                size--;
            }
            if (carry > 0) {
                result.addFirst(1);
            }
            return result;
        }

        private LinkedList<Integer> numToList(int num) {
            LinkedList<Integer> list = new LinkedList<>();
            while (num / 10 > 0) {
                list.addFirst(num % 10);
                num = num / 10;
            }
            list.addFirst(num % 10);
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}