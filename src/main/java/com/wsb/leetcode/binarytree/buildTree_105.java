package com.wsb.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class buildTree_105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {

        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;

        Integer rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lengthOfLeft = rootIndex - inBegin;
        root.left = findNode(preorder, preBegin + 1, preBegin + lengthOfLeft + 1, inorder, inBegin, inBegin + lengthOfLeft);
        root.right = findNode(preorder, preBegin + lengthOfLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }

}
