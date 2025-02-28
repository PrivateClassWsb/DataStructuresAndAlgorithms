package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorderTraversal_145 {

    public List<Integer> postorderTraversal1(TreeNode root) {

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

    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }

        }

        Collections.reverse(res);

        return res;
    }
}
