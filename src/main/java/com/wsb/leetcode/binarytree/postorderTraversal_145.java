package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
