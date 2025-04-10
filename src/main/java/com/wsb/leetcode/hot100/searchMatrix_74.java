package com.wsb.leetcode.hot100;

public class searchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colLen = matrix[0].length;
        int[] num = null;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[colLen - 1]){
                num = ints;
            }
        }
        if (num == null) return false;
        return binarySearch(num, target);

    }

    private boolean binarySearch(int[] num, int target) {
        int left = 0, right = num.length - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (target < num[mid]){
                right = mid - 1;
            }else if (target > num[mid]){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
