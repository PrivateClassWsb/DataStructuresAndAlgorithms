package com.wsb.leetcode.greedy;

public class canCompleteCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            res += gas[i] - cost[i];
            if (res < 0){
                res = 0;
                start = i + 1;
            }
        }
        if (totalGas < totalCost){
            return -1;
        }
        return start;
    }
}
