package com.slg.leetcode.editor.cn;

import com.slg.leetcode.editor.cn.ds.ListNode;

public class MergeTwoSortedLists{
        public static void main(String[] args) {
            Solution solution = new MergeTwoSortedLists().new Solution();
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**
             * 递归思路：
             * 1、首先确定递归函数返回的是啥，一定是返回l1和l2中间更小的那个
             * 2、确定了递归的返回值，接下来就要考虑如何在递归逻辑中把返回值给运用起来
             * 3、如果返回的是l1，那就需要让l1后面拼接上l1.next和l2的拼接，这就递归起来了
             */
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                if (l1 == null) {
                    return l2;
                }
                if (l2 == null) {
                    return l1;
                }
                if (l1.val < l2.val) {
                    if (l1.next != null) {
                        l1.next = mergeTwoLists(l1.next, l2);
                    }else{
                        l1.next = l2;
                    }
                    return l1;
                }else{
                    if (l2.next != null) {
                        l2.next = mergeTwoLists(l2.next, l1);
                    }else{
                        l2.next = l1;
                    }
                    return l2;
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)

        class Solution1 {
            /**
             * 思路：遍历l1,当p1大于等于p2时将p2节点链到p1前面，否则p1向后移动
             */
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                ListNode p1 = l1;
                ListNode p2 = l2;
                ListNode p1Pre = null;

                if (p1 == null) {
                    return p2;
                }
                if (p2 == null) {
                    return p1;
                }

                while (p1 != null) {
                    //l2已经遍历完了
                    if (p2 == null) {
                        break;
                    }
                    if (p1.val < p2.val) {
                        p1Pre = p1;
                        p1 = p1.next;
                    }else{
                        //注意这里一定要赋值之后就立即把p2指向下一个，否则一旦p2cut.next一改变，p2也会跟着变,l2就丢失了!
                        ListNode p2cut = p2;
                        p2 = p2.next;

                        if (p1Pre != null) {
                            p1Pre.next = p2cut;
                        }else{
                            //p2cut需要拼到首节点,此时需要将l1重新指向链首
                            l1 = p2cut;
                        }
                        p2cut.next = p1;
                        p1Pre = p2cut;
                    }
                }
                //l2尚未遍历完,且当前链中的值全部大于l1,直接拼后面
                if (p2 != null) {
                    p1Pre.next = p2;
                }
                return l1;
            }
        }
}