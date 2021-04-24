package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：用一个双向链表来置顶，用一个HashMap来存放缓存
     * 只有链表的前2个有资格在map里
     * 注意不管是put还是get都需要置顶
     * 如果想要O(1)复杂度的话只能自己设计链表，这样才能保证删除当前node时断开自己拼上左右链接
     * 如果使用LinkedList那么无法访问ll内部的Node，它是private类型的
     */
    class LRUCache {
        int capacity = 0;
        private MyLinkedList keyList = new MyLinkedList();
        private Map<Integer, Node> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int rs = -1;
            if (cache.containsKey(key)) {
                rs = cache.get(key).value;
                //置顶
                keyList.remove(cache.get(key));
                keyList.addFirst(cache.get(key));
            }
            return rs;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                //找到key对应的节点并设置新值
                cache.get(key).value = value;
                //将该节点置顶
                keyList.remove(cache.get(key));
                keyList.addFirst(cache.get(key));
            } else {
                if (keyList.getSize() < capacity) {
                    //直接添加即可
                    Node newNode = new Node(key, value);
                    cache.put(key, newNode);
                    keyList.addFirst(newNode);
                } else {
                    Node newNode = new Node(key, value);
                    //加入顶部
                    keyList.addFirst(newNode);
                    //删除尾部
                    Node lastNode = keyList.removeLast();
                    //加入缓存
                    cache.put(key, newNode);
                    //从缓存中清除
                    cache.remove(lastNode.key);
                }
            }
        }
    }

    /**
     * 链表技巧：做任何操作之前，先把node.pre和node.next用一个新变量存起来
     * 方便后面的一系列操作
     */
    class MyLinkedList {
        private int size = 0;
        private Node head;
        private Node tail;

        public int getSize() {
            return size;
        }

        public void addFirst(Node node) {
            size++;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        public Node removeLast() {
            if (size > 0) {
                size--;
                Node removedTail = tail;
                if (tail.pre != null) {
                    Node tailPre = tail.pre;
                    tailPre.next = null;
                    tail = tailPre;
                }else{
                    //就剩最后一个节点了，删完全为空
                    head = null;
                    tail = null;
                }
                return removedTail;
            }else{
                return null;
            }
        }

        public void remove(Node node) {
            if (size > 0) {
                size--;
                Node nodePre = node.pre;
                Node nodeNext = node.next;
                if (nodePre != null) {
                    if (nodeNext != null) {
                        nodePre.next = nodeNext;
                        nodeNext.pre = nodePre;
                    }else{
                        //要删除的就是tail
                        nodePre.next = null;
                        tail = nodePre;
                    }
                }else{
                    if (nodeNext != null) {
                        //要删除的是head节点
                        nodeNext.pre = null;
                        head = nodeNext;
                    }else{
                        //要删除的是链表中最后一个节点
                        head = null;
                        tail = null;
                    }
                }
            }
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}