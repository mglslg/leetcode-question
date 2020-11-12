package com.slg.leetcode.editor.cn;

import java.util.*;

public class CheapestFlightsWithinKStops{
        public static void main(String[] args) {
            Solution solution = new CheapestFlightsWithinKStops().new Solution();
            //int[][] flights={{1,2,5},{1,3,2},{3,2,8},{3,5,7},{2,5,2},{2,4,4},{4,5,6},{5,6,1},{4,6,3}};
            //int[][] flights={{0,1,100},{1,2,100},{0,2,500}};
            int[][] flights={{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
            solution.findCheapestPrice(5, flights, 0, 4, 1);
        }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            //记录两个东西,一个costs表一个parents表
            public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
                //首先构建一个节点图的Map
                Map<Integer, Map<Integer, Integer>> graph = buildGraph(flights);
                //用来记录从原点到某个节点的最短开销
                Map<Integer, Integer> costs = new HashMap<>();
                //用来记录某个节点的上一个节点是什么
                Map<Integer, Integer> parents = new HashMap<>();
                //用来记录已经处理过的节点
                Set<Integer> processed = new HashSet<>();

                //遍历节点核心逻辑
                Queue<Integer> queue = new PriorityQueue<>();
                queue.add(src);
                costs.put(src, 0);
                //while (!queue.isEmpty()) { //Dijkstra算法需要这么写，本算法不需要
                for (int i = 0; i < K+1; i++) {
                    Integer currNode = queue.poll();
                    processed.add(currNode);
                    Map<Integer, Integer> routeMap = graph.get(currNode);
                    if (routeMap != null) {
                        for (Integer nextNode : routeMap.keySet()) {
                            int edgeWeight = routeMap.get(nextNode);
                            int currNodeCost = costs.get(currNode);
                            //找到了从原点到nextNode更小的开销,更新costs表和parents表
                            if (!costs.containsKey(nextNode) || (currNodeCost + edgeWeight < costs.get(nextNode))) {
                                costs.put(nextNode, currNodeCost + edgeWeight);
                                parents.put(nextNode, currNode);
                            }
                            //将当前节点的后续节点加入队列，如果已经处理过则跳过(防止有环？)
                            if (!processed.contains(nextNode) && !queue.contains(nextNode)) {
                                queue.add(nextNode);
                            }
                        }
                    }
                }
                if (costs.containsKey(dst)) {
                    return costs.get(dst);
                }
                return -1;
            }

            /**
             * 更新当前节点后续节点的costs表
             */
            private void updateAndGetLowestNode(int currNode, Map<Integer, Integer> routeMap, Map<Integer, Integer> costs,Map<Integer, Integer> parents) {
                for (Integer nextNode : routeMap.keySet()) {
                    int edgeWeight = routeMap.get(nextNode);
                    int currNodeCost = costs.get(currNode);
                    if (!costs.containsKey(nextNode) || (currNodeCost + edgeWeight < costs.get(nextNode))) {
                        costs.put(nextNode, edgeWeight);
                        parents.put(nextNode, currNode);
                    }
                }
            }

            /** 根据二维数组构建带权重的图 */
            private Map<Integer, Map<Integer, Integer>> buildGraph(int[][] flights){
                Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
                for (int i = 0; i < flights.length; i++) {
                    int nodeIdx = flights[i][0];
                    int nextNodeIdx=flights[i][1];
                    int weight=flights[i][2];
                    if (graph.get(nodeIdx) != null) {
                        Map<Integer, Integer> edgeMap = graph.get(nodeIdx);
                        edgeMap.put(nextNodeIdx, weight);
                    }else{
                        Map<Integer, Integer> edgeMap = new HashMap<>();
                        edgeMap.put(nextNodeIdx, weight);
                        graph.put(nodeIdx, edgeMap);
                    }
                    //将下一个节点也添加到图里,不管其有没有出度,如果有出度也会在接下来被设置到
                    //todo 这里有错！！！如果有环的话节点的next会被重新置空！
                    graph.put(nextNodeIdx, null);
                }
                return graph;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
	
}