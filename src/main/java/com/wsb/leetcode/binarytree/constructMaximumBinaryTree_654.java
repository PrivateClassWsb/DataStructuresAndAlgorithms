package com.wsb.leetcode.binarytree;

import java.util.Arrays;
import java.util.HashMap;

public class constructMaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums);
    }

    private TreeNode build(int[] nums) {

        if (nums.length == 0) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        TreeNode root = new TreeNode(max);
        Integer rootIndex = map.get(max);
        int[] leftNums = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] rightNums = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);
        root.left = build(leftNums);
        root.right = build(rightNums);
        return root;
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        return build1(nums, 0, nums.length);
    }

    private TreeNode build1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) return null;
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
        int maxIndex = leftIndex;
        int max = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build1(nums, leftIndex, maxIndex);
        root.right = build1(nums, maxIndex + 1, rightIndex);
        return root;
    }

    public static void main(String[] args) {
        constructMaximumBinaryTree_654 test = new constructMaximumBinaryTree_654();
        int[] nums = {3,2,1,6,0,5};
        System.out.println(test.constructMaximumBinaryTree(nums));
    }
}
