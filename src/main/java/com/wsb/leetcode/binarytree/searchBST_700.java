package com.wsb.leetcode.binarytree;

public class searchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        if (root.val > val){
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }

    }

    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val){
                root = root.left;
            }else if (root.val < val){
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }
}
