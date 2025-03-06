package com.wsb.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class buildTree_106 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd){
            return null;
        }
        Integer rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lengthOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lengthOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lengthOfLeft, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        buildTree_106 test = new buildTree_106();
        int[] inorder = { 9,3,15,20,7 };
        int[] postorder = { 9,15,7,20,3 };
        TreeNode root = test.buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}
