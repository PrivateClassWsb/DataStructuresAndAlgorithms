package com.wsb.leetcode.hot100;

import java.util.ArrayList;

public class flatten_114 {
    ArrayList<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
