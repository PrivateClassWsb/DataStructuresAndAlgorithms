package com.wsb.leetcode.DynamicProgramming;

public class rob_337 {
    public int rob(TreeNode root) {
        // dp[0] : 不偷当前节点所能得到的最大值
        // dp[1] : 偷当前节点所能得到的最大值
        int[] dp = new int[2];
        dp= robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robTree(TreeNode root) {
        if (root == null){
            return new int[]{0, 0};
        }

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        // 不偷 当前节点
        int val1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷 当前节点
        int val2 = root.val + left[0] + right[0];

        return new int[]{val1, val2};
    }
}
