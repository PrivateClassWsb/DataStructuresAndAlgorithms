package com.wsb.leetcode.hot100;

public class maxPathSum_124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int temp = root.val + left + right;
        max = Math.max(max, temp);
        return root.val + Math.max(left, right);
    }
}
