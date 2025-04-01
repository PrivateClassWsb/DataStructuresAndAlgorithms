package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_56 {
    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    // 输出：[[1,6],[8,10],[15,18]]
    // 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]){
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }else {
                list.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            }
        }
        list.add(new int[]{start, intervals[intervals.length - 1][1]});
        return list.toArray(new int[list.size()][]);
    }
}
