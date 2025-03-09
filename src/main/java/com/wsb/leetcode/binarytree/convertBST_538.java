package com.wsb.leetcode.binarytree;

public class convertBST_538 {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    private void convertBST1(TreeNode root) {
        if (root == null) return;
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
