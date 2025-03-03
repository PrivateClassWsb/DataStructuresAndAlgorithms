package com.wsb.leetcode.binarytree;

public class isSubtree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;
        boolean compareWhole = compareSame(root, subRoot);
        boolean compareLeft = isSubtree(root.left, subRoot);
        boolean compareRight = isSubtree(root.right, subRoot);
        return compareWhole || compareLeft || compareRight;
    }

    private boolean compareSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        boolean compareLeft = compareSame(p.left, q.left);
        boolean compareRight = compareSame(p.right, q.right);
        return compareLeft && compareRight;
    }
}
