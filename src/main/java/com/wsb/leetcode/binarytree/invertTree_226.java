package com.wsb.leetcode.binarytree;

import java.util.ArrayDeque;

public class invertTree_226 {

    public TreeNode invertTree(TreeNode root) {
         if (root == null) return null;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }

        return root;
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}
