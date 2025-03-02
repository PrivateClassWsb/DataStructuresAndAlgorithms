package com.wsb.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth_111 {

    public int minDepth(TreeNode root) {
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
}
