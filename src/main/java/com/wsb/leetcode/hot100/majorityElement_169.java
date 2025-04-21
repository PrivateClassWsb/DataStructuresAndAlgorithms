package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class majorityElement_169 {

    public int majorityElement(int[] nums){
        int cnt = 0;
        int temp = 0;
        for (int num : nums) {
            if (cnt == 0){
                temp = num;
            }
            if (num == temp){
                cnt += 1;
            }else {
                cnt += -1;
            }
        }
        return temp;
    }

    public int majorityElement1(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > nums.length / 2){
                res = entry.getKey();
            }
        }
        return res;
    }
}
