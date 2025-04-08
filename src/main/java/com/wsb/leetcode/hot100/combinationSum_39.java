package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum_39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        int startIndex = 0;
        backtracking(candidates, target, startIndex, sum);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIdex, int sum) {
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
