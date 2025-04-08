package com.wsb.leetcode.hot100;

public class exist_79 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                boolean flag = check(board, visited, word, r, c, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[][] board, boolean[][] visited, String s, int r, int c, int k){
        if (board[r][c] != s.charAt(k)){
            return false;
        }else if (k == s.length() - 1){
            return true;
        }
        visited[r][c] = true;
        boolean res = false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && !visited[newR][newC]){
                res = check(board, visited, s, newR, newC, k + 1);
                if (res){
                    break;
                }
            }
        }
        visited[r][c] = false;
        return res;
    }
}
