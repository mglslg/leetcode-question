package com.slg.leetcode.editor.cn.util;

import com.alibaba.fastjson.JSONArray;
import com.slg.leetcode.editor.cn.ds.ListNode;
import com.slg.leetcode.editor.cn.ds.TreeNode;

import java.util.LinkedList;
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

    public static TreeNode buildTree(Integer[] treeArray) {
        if (treeArray.length == 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(treeArray[0]);
        queue.add(root);
        for (int i = 1; i < treeArray.length; i = i + 2) {
            TreeNode currRoot = queue.pollFirst();
            if (treeArray[i] != null) {
                TreeNode left = new TreeNode(treeArray[i]);
                currRoot.left = left;
                queue.add(left);
            }
            if (i + 1 < treeArray.length && treeArray[i + 1] != null) {
                TreeNode right = new TreeNode(treeArray[i + 1]);
                currRoot.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
