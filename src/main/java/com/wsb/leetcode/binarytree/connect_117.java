package com.wsb.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class connect_117 {

    public Node_next connect(Node_next root) {
        if (root == null)  return root;
        Queue<Node_next> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node_next node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == size - 1) {
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }
}
