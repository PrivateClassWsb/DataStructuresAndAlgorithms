package com.wsb.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class countNodes_222 {
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        int cnt = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            cnt += size;
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return cnt;
    }

    public int countNodes2(TreeNode root){
        if (root == null) return 0;
        int leftCount = countNodes2(root.left);
        int rightCount = countNodes2(root.right);
        return leftCount + rightCount + 1;
    }

    public int countNodes3(TreeNode root){
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth)
            return (2<<leftDepth) - 1;
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }
}
