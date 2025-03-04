package com.wsb.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth_104 {

    public int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth2(root.left);   // 左
        int rightDepth = maxDepth2(root.right); // 右
        int depth = Math.max(leftDepth, rightDepth) + 1;    // 中
        return depth;
    }


    int maxnum = 0;
    public int maxDepth3(TreeNode root){
        ans(root, 0);
        return maxnum;
    }

    private void ans(TreeNode tr, int tmp) {
        if (tr == null) return;
        tmp++;
        maxnum = Math.max(maxnum, tmp);
        ans(tr.left, tmp);
        ans(tr.right, tmp);
        tmp--;
    }
}
