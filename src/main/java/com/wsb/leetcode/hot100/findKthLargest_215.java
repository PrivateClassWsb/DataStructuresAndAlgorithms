package com.wsb.leetcode.hot100;

public class findKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
}

    private int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[k], i = l - 1, j = r + 1;
        while (i < j){
            do {
                i++;
            }while (nums[i] < x);
            do {
                j--;
            }while (nums[j] > x);
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k <= j){
            return quickselect(nums, l, j, k);
        }else {
            return quickselect(nums, j + 1, r, k);
        }
    }


    public static void main(String[] args) {
        findKthLargest_215 sol = new findKthLargest_215();
        int[] nums = {7,6,5,4,3,2,1};
        int k = 2;
        System.out.println("第 " + k + " 大的元素是：" + sol.findKthLargest(nums, k));
    }
}
