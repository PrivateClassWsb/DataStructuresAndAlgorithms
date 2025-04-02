package com.wsb.leetcode.hot100;

public class rotate_48 {
    public void rotate(int[][] matrix) {
        /*
           int n = matrix.length;
           matrix[row][col] 经顺时针旋转90°到了 matrix[col][n - row - 1]
           即 下一个位置的row = 上一个位置的col。 下一个位置的col = n - 上一个位置的row - 1
           即 matrix[row][col] -> matrix[col][n - row - 1] -> matrix[n - row - 1][n - col - 1]
           -> matrix[n - col - 1][row] -> matrix[row][col]
         */
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
