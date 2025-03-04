package com.wsb.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth_559 {
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
        }
        return depth;
    }

    public int maxDepth2(Node root){
        if (root == null) return 0;
        int depth = 0;
        if (root.children != null){
            for (Node child : root.children) {
                depth= Math.max(depth, maxDepth2(child));
            }
        }
        return depth + 1;
    }
}
