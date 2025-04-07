package com.wsb.leetcode.hot100;

public class numIslands_200 {
    void dfs(char[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if (grid[r][c] != '1') return;
        grid[r][c] = '2';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1'){
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        numIslands_200 test = new numIslands_200();
        System.out.println(test.numIslands(grid));
    }
}
