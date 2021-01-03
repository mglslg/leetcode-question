package com.slg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            //你大爷的，判断0有意思吗？
            if (numRows == 0) {
                return new ArrayList<>();
            }
            if (numRows == 1) {
                List<List<Integer>> tri = new ArrayList<>();
                List<Integer> first = new ArrayList<>();
                first.add(1);
                tri.add(first);
                return tri;
            }
            List<List<Integer>> latestTri = generate(numRows - 1);
            List<Integer> lastLevel = latestTri.get(latestTri.size() - 1);

            //装配新的一层
            List<Integer> currLevel = new ArrayList<>();
            latestTri.add(currLevel);

            for (int i = 0; i < lastLevel.size(); i++) {
                //判断是否为第一个,如果是则为最左端直接添加1即可
                if (i == 0) {
                    currLevel.add(1);
                } else {
                    currLevel.add(lastLevel.get(i - 1) + lastLevel.get(i));
                }
            }
            //循环结束后最后再补个1即可
            currLevel.add(1);

            return latestTri;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}