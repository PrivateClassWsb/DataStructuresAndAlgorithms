package com.wsb.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

public class invertTree_226 {

    // 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 层序遍历
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                swapNode(node);
                if (node.left != null){
                    deque.add(node.left);
                }
                if (node.right != null){
                    deque.add(node.right);
                }
            }
        }
        return root;
    }

    private void swapNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
