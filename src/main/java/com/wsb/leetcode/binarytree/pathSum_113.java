package com.wsb.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class pathSum_113 {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return res;

        preorderdfs(root, targetSum, res, path);

        return res;
    }

    private static void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, ArrayList<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0){
                res.add(path);
            }
            return;
        }
        if (root.left != null) {
            preorderdfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            preorderdfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode right4 = new TreeNode(2);
        TreeNode left3 = new TreeNode(7);
        TreeNode left2 = new TreeNode(11, left3, right4);
        TreeNode left1 = new TreeNode(4, left2, null);
        TreeNode left4 = new TreeNode(13);
        TreeNode left5 = new TreeNode(5);
        TreeNode right6 = new TreeNode(1);
        TreeNode right5 = new TreeNode(4, left5, right6);
        TreeNode right1 = new TreeNode(8, left4, right5);
        TreeNode root = new TreeNode(5, left1, right1);
        pathSum(root, 22);
    }
}
