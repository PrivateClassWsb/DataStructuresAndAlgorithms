package com.wsb.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int remove = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pre){
                remove++;
                pre = Math.min(intervals[i][1], pre);
            }else {
                pre = intervals[i][1];
            }
        }
        return remove;
    }
}
