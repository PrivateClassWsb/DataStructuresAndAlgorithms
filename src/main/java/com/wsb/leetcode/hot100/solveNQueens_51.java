package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens_51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtracking(n, 0, chessboard);
        return res;
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        if (row == n){
            res.add(array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, chessboard, n)){
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> array2List(char[][] chessboard) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }

    private boolean isValid(int row, int col, char[][] chessboard, int n) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (chessboard[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }
}
