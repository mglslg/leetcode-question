package com.slg.leetcode.editor.cn;

public class ImplementStrstr{
        public static void main(String[] args) {
                Solution solution = new ImplementStrstr().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int strStr(String haystack, String needle) {
                char[] hayChars = haystack.toCharArray();
                char[] needleChars = needle.toCharArray();
                int idx = 0;
                int startIdx = 0;
                for (int i = 0; i < hayChars.length; i++) {
                    if (idx < needleChars.length) {
                        if (hayChars[i] == needleChars[idx]) {
                            if (startIdx == 0) {
                                startIdx = i;
                            }
                            idx++;
                        }else{
                            idx = 0;
                            startIdx = -1;
                        }
                    }else{
                        return startIdx;
                    }
                }
                return -1;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}