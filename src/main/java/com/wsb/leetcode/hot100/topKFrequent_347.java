package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.PriorityQueue;

public class topKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        map.forEach((key, value) -> {
            if (priorityQueue.size() < k){
                priorityQueue.add(new int[]{key, value});
            }else {
                if (priorityQueue.peek()[1] < value){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, value});
                }
            }
        });
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }
}
