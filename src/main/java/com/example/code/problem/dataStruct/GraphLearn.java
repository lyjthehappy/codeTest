package com.example.code.problem.dataStruct;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class GraphLearn {

    // 邻接表

    //邻接矩阵

    //bfs
    public static void scanGraph(List<List<Integer>> arrs) {
        List<Integer> arr = arrs.get(0);
        int nodeSize = arr.size();
        boolean[] visited = new boolean[nodeSize];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            System.out.println("start scan area");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.offer(i);
            while (!deque.isEmpty()) {
                Integer cur = deque.pollFirst();
                System.out.println("visited:" + cur + " node");
                visited[cur] = true;
                List<Integer> curLinkNodes = arrs.get(cur);
                for (int i1 = 0; i1 < curLinkNodes.size(); i1++) {
                    if (!visited[i1] && curLinkNodes.get(i1) > 0) {
                        deque.offer(i1);
                    }
                }
            }
            System.out.println("end scan area");

        }
        System.out.println("scan end");

    }

    public static void dfsScan(List<List<Integer>> arrs) {
        int size = arrs.get(0).size();
        boolean[] visited = new boolean[size];
        dfsScanHelper(arrs, 0, visited);
    }

    public static void dfsScanHelper(List<List<Integer>> arrs, int curNode, boolean[] visited) {
        if (visited[curNode]) return;

        log.info("visited-{}", curNode);
        visited[curNode] = true;
        List<Integer> linkNodes = arrs.get(curNode);
        for (Integer linkNode : linkNodes) {


            dfsScanHelper(arrs, linkNode, visited);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(0, 0, 0, 1, 0),
                Arrays.asList(0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 0, 3, 0),
                Arrays.asList(0, 0, 0, 0, 4),
                Arrays.asList(1, 0, 0, 0, 0));
        scanGraph(graph);
        dfsScan(graph);
    }


}
