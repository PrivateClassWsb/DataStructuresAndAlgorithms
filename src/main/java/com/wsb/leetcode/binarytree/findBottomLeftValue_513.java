package com.wsb.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class findBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {

        if (root == null) return 0;
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == 0){
                    res = node.val;
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return res;

    }
}
