package com.slg.leetcode.editor.cn;

public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int startIdx = 0;
            int endIdx = s.length - 1;
            while (startIdx < endIdx) {
                char temp = s[startIdx];
                s[startIdx] = s[endIdx];
                s[endIdx] = temp;
                startIdx++;
                endIdx--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}