package com.wsb.leetcode.hot100;

public class isValidBST_98 {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        // 因为二叉搜索树是升序的 这里的max相当于记录的是前一个节点的值 所以 如果当前节点的值比前一个节点的值大  那就返回false
        if (max != null && root.val <= max.val) return false;
        max = root;
        boolean right = isValidBST(root.right);
        return right;
    }
}
