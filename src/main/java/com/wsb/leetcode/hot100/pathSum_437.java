package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class pathSum_437 {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curSum, int targetSum) {
        if (root == null) return 0;
        int ret = 0;
        curSum += root.val;
        ret += prefix.getOrDefault(curSum - targetSum, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        ret += dfs(root.left, prefix, curSum, targetSum);
        ret += dfs(root.right, prefix, curSum, targetSum);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) - 1);
        return ret;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        res += rootSum(root, targetSum);
        res += pathSum1(root.left, targetSum);
        res += pathSum1(root.right, targetSum);
        return res;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == targetSum) res++;
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }
}
