package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();

        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            double avg = sum / size;
            result.add(avg);
        }

        return result;
    }
}
