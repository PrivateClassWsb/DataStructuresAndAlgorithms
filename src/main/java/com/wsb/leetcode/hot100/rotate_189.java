package com.wsb.leetcode.hot100;

public class rotate_189 {

    public void rotate(int[] nums, int k) {
        // 如果数组长度=7，k=10.那么用 取模运算 k % n 来找到等效的右移次数。
        // 因为 如果我们直接右移 10 次，相当于：右移 7 次后，数组回到原位。再右移 3 次，结果等同于 k = 3 的情况。
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }
}
