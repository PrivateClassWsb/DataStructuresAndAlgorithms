package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
