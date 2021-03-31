package com.slg.leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kth = new KthLargestElementInAStream()
                .new KthLargest(3, new int[]{4, 5, 8, 2});

        kth.add(3);
        kth.add(5);
        kth.add(10);
        kth.add(9);
        kth.add(4);

        /*PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(19);
        queue.add(20);
        queue.add(15);
        queue.add(6);
        queue.add(8);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }*/

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 思路：直接使用jdk的优先队列，其原理是一个小顶堆
     * 构建一个大小为k的小顶堆，那么堆顶元素就是k个数里的最小值，也就是第k大的元素！
     */
    class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue(k);
            for (int n : nums) {
                if (pq.size() < k) {
                    pq.offer(n);
                }else{
                    if (pq.peek() <= n) {
                        pq.poll();
                        pq.offer(n);//offer就相当于add
                    }
                }
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            }else{
                if (val > pq.peek()) {
                    pq.poll();
                    pq.offer(val);
                }
            }
            return pq.peek();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}