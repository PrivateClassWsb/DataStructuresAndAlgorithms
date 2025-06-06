package com.wsb.leetcode.hot100;

import com.google.errorprone.annotations.Var;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets_78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        int startIndex = 0;
        backtracking(nums, startIndex);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
