package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi{
        public static void main(String[] args) {
                Solution solution = new PascalsTriangleIi().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public List<Integer> getRow(int rowIndex) {
                //真是日了狗，居然从0开始数行……那上一道你怎么不这样？？？
                if (rowIndex == 0) {
                    List<Integer> firstRow = new ArrayList<>();
                    firstRow.add(1);
                    return firstRow;
                }
                List<Integer> row = getRow(rowIndex - 1);

                //要求空间复杂度在O(k)，因此需要在当前row中做原地替换
                int preNum = 0;
                for (int i = 0; i < row.size(); i++) {
                    int preNumTemp = row.get(i);
                    row.set(i, row.get(i) + preNum);
                    preNum = preNumTemp;
                }
                row.add(1);
                return row;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}