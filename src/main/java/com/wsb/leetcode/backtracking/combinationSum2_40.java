package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2_40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        int startIndex = 0;
        backtracking(candidates, target, startIndex);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }
}
