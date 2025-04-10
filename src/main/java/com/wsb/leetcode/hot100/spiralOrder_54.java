package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        // 上下边界
        int top = 0, bottom = matrix.length - 1;
        // 左右边界
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom){
                for (int i = right; i >= left ; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                if (left <= right){
                    for (int i = bottom; i >= top ; i--) {
                        list.add(matrix[bottom][left]);
                    }
                    left++;
                }

            }

        }

        return list;
    }
}
