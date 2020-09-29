package com.slg.leetcode.editor.cn;

import java.util.Stack;

public class BackspaceStringCompare{
        public static void main(String[] args) {
                Solution solution = new BackspaceStringCompare().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public boolean backspaceCompare(String S, String T) {
                Stack<Character> stackA = new Stack<Character>();
                Stack<Character> stackB = new Stack<Character>();

                for (char c : S.toCharArray()) {
                    if(c != '#'){
                        stackA.push(c);
                    }else{
                        if(!stackA.isEmpty()){
                            stackA.pop();
                        }
                    }
                }

                for (char c : T.toCharArray()) {
                    if(c != '#'){
                        stackB.push(c);
                    }else{
                        if(!stackB.isEmpty()){
                            stackB.pop();
                        }
                    }
                }

                return stackA.toString().equals(stackB.toString());
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}