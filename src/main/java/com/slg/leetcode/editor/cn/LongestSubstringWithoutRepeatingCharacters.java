package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> memo = new HashMap<>();
            int count = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (memo.containsKey(s.charAt(i))) {
                    //当前字符x已经出现过了，必须找到下一个非x的字符，并将其索引idx赋给start
                    int nextIdx = memo.get(s.charAt(i));
                    //这里要注意卡窗口的大小，start不能大于end
                    while (nextIdx < i && s.charAt(i) == s.charAt(nextIdx)) {
                        nextIdx++;
                    }
                    start = nextIdx;
                    //要保证map中只存放start到end区间的值
                    memo.clear();
                    for (int j = start; j <= i; j++) {
                        memo.put(s.charAt(j), j);
                    }
                } else {
                    memo.put(s.charAt(i), i);
                    if (i - start + 1 > count) {
                        count = i - start + 1;
                    }
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}