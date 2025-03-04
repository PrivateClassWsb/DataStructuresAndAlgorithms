package com.wsb.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth_111 {

    public int minDepth1(TreeNode root) {
        int min = 0;
        if (root == null) return min;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            min++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null && node.right == null) return min;
            }
        }
        return min;
    }

    public int minDepth2(TreeNode root){
        if (root == null) return 0;
        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);
        if (root.left == null){
            return rightDepth + 1;
        }
        if (root.right == null){
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    int depth = 0;
    int minDepth = Integer.MAX_VALUE;
    public int minDepth3(TreeNode root){
        dep(root);
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }

    private void dep(TreeNode root) {
        if (root == null) return;
        depth++;
        dep(root.left);
        dep(root.right);
        if (root.left == null && root.right == null)
            minDepth = Math.min(minDepth, depth);
        depth--;
    }
}
