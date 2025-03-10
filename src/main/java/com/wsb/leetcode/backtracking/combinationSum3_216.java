package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum3_216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    private void backtracking(int k, int targetSum, int startIndex, int sum) {
        if (sum > targetSum)
            return;
        if (path.size() == k){
            if (sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, targetSum, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
