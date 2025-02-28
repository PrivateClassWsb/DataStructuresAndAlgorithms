package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(4, node2, node3);
        TreeNode root = new TreeNode(5, node1, node4);
        System.out.println(preorderTraversal2(root));
    }

}
