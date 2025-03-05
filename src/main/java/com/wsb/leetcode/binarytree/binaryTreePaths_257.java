package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, ArrayList<Integer> paths, ArrayList<String> res) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
