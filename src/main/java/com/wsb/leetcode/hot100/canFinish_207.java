package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class canFinish_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] edge = new int[numCourses];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]); // 构建邻接表
            edge[prerequisite[0]]++;    // 标记初始每个节点的入度
        }
        for (int i = 0; i < edge.length; i++) {
            if (edge[i] == 0){
                deque.add(i);
            }
        }
        int visited = 0;
        while (!deque.isEmpty()){
            visited++;
            int poll = deque.poll();
            for (int i : list.get(poll)) {
                edge[i]--;
                if (edge[i] == 0){
                    deque.add(i);
                }
            }
        }
        return visited == numCourses;
    }
}
