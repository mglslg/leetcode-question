package com.slg.leetcode.editor.cn;

public class ImplementStrstr{
        public static void main(String[] args) {
            Solution solution = new ImplementStrstr().new Solution();
            solution.strStr("a", "a");
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**
             * 外层循环要必须遍历完,结束之后就返回-1
             * startIdx=0
             * 内层循环就是不断的找startIdx,一旦匹配失败就将idx重新归0，直到子串遍历完
             * 一旦字串遍历完则返回startIdx
             *
             * 卧槽这个一旦第一次匹配不成功之后需要从头找!!!
             * */
            public int strStr(String haystack, String needle) {
                char[] hayChars = haystack.toCharArray();
                char[] needleChars = needle.toCharArray();
                if (hayChars.length < needleChars.length) {
                    return -1;
                }
                if (hayChars.length >= needleChars.length && needleChars.length == 0) {
                    return 0;
                }
                int idx = 0;
                int startIdx = -1;
                for (int i = 0; i < hayChars.length; i++) {
                    if (idx < needleChars.length) {
                        if (hayChars[i] == needleChars[idx]) {
                            if (startIdx == -1) {
                                startIdx = i;
                            }
                            idx++;
                        }else{
                            startIdx = -1;
                            idx = 0;
                        }
                    }else{
                        //匹配成功(字串长度为0情况也适用)
                        return startIdx;
                    }
                }
                //两个字符串一样长
                if (idx >= needleChars.length) {
                    return startIdx;
                }
                return -1;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}