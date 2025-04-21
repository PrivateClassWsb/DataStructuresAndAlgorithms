package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class singleNumber_136 {
    public int singleNumber(int[] nums){
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() == 1){
                res = entry.getKey();
            }
        }
        return res;
    }
}
