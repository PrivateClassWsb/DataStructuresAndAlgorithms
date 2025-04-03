package com.wsb.leetcode.hot100;

public class searchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] > target){
                y--;
            }else {
                x++;
            }

        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0){
                return true;
            }
        }
        return false;
    }

    private int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
