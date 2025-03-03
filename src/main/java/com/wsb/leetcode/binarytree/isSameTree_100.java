package com.wsb.leetcode.binarytree;

public class isSameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);

    }

    private boolean compare(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        boolean compareLeft = compare(p.left, q.left);
        boolean compareRight = compare(p.right, q.right);
        return compareLeft && compareRight;
    }
}
