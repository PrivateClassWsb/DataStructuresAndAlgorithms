package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal_94 {

    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

}
