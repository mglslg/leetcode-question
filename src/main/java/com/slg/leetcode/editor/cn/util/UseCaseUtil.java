package com.slg.leetcode.editor.cn.util;

import com.alibaba.fastjson.JSONArray;
import com.slg.leetcode.editor.cn.ds.ListNode;

import java.util.Stack;

public class UseCaseUtil {
    public static ListNode buildLinkedList(String useCaseStr){
        JSONArray array = JSONArray.parseArray(useCaseStr);
        Stack<Integer> stack = new Stack();
        for (Object o : array) {
            stack.push((Integer) o);
        }
        ListNode head = null;
        ListNode lastHead = null;
        while(!stack.empty()){
            head = new ListNode(stack.pop());
            head.next = lastHead;
            lastHead = head;
        }
        return head;
    }
}
