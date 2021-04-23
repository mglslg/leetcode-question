package com.slg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：用一个双向链表来置顶，用一个HashMap来存放缓存
     * 只有链表的前2个有资格在map里
     * 注意不管是put还是get都需要置顶
     * 想要O(1)复杂度可以考虑map中存node而非直接存值
     * 而在链表中删除node
     */
    class LRUCache {
        int capacity = 0;
        private LinkedList<Integer> keyList = new LinkedList<>();
        private Map<Integer, Integer> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int rs = -1;
            if (cache.containsKey(key)) {
                rs = cache.get(key);
                //将key在链表中置顶
                keyList.remove(keyList.indexOf(key));
                keyList.addFirst(key);
            }
            return rs;
        }

        public void put(int key, int value) {
            if (keyList.size() < capacity) {
                if(!cache.containsKey(key)){
                    cache.put(key, value);
                    keyList.addFirst(key);
                }else{
                    //置顶
                }
            }else{
                keyList.addFirst(key);
                int last = keyList.removeLast();
                cache.remove(last);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}