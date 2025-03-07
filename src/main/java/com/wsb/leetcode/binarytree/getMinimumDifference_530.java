package com.wsb.leetcode.binarytree;

public class getMinimumDifference_530 {

    TreeNode pre;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null){
            this.result = Math.min(this.result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }

}
