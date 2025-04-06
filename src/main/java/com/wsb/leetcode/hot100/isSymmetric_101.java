package com.wsb.leetcode.hot100;

public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return compareNode(root.left, root.right);
    }

    private boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null && right != null){
            return false;
        }
        if (right == null && left != null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        boolean outside = compareNode(left.left, right.right);
        boolean inside = compareNode(left.right, right.left);
        return outside && inside;
    }
}
