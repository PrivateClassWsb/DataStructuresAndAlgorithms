package com.wsb.leetcode.hot100;

import java.util.HashMap;

public class buildTree_105 {
    /*
        preorder = [3,9,20,15,7],
        inorder = [9,3,15,20,7]
     */
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = map.get(preorder[preBegin]);
        int leftLength = rootIndex - inBegin;
        root.left = findNode(preorder, preBegin + 1, preBegin + leftLength + 1,
                inorder, inBegin, inBegin + leftLength);
        root.right = findNode(preorder, preBegin + leftLength + 1, preEnd,
                inorder, rootIndex + 1, inEnd);
        return root;
    }
}
