package com.wsb.leetcode.stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if (pq.peek()[1] < entry.getValue()){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
