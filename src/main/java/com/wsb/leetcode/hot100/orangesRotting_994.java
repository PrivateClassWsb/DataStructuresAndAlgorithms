package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class orangesRotting_994 {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int cnt = 0; // 表示新鲜橘子的数量
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1){
                    cnt++;
                }else if (grid[r][c] == 2){
                    deque.add(new int[]{r, c}); // 作为第0层起始循环
                }
            }
        }
        int round = 0;
        while (cnt > 0 && !deque.isEmpty()){
            int size = deque.size();
            round++;
            for (int i = 0; i < size; i++) {
                int[] orange = deque.poll();
                int r = orange[0];
                int c = orange[1];
                if ((r - 1) >= 0 && grid[r - 1][c] == 1){
                    grid[r - 1][c] = 2;
                    cnt--;
                    deque.add(new int[]{r - 1, c});
                }
                if ((r + 1) < grid.length && grid[r + 1][c] == 1){
                    grid[r + 1][c] = 2;
                    cnt--;
                    deque.add(new int[]{r + 1, c});
                }
                if ((c - 1) >= 0 && grid[r][c - 1] == 1){
                    grid[r][c - 1] = 2;
                    cnt--;
                    deque.add(new int[]{r, c - 1});
                }
                if ((c + 1) < grid[0].length && grid[r][c + 1] == 1){
                    grid[r][c + 1] = 2;
                    cnt--;
                    deque.add(new int[]{r, c + 1});
                }
            }
        }
        if (cnt > 0) {
            return -1;
        }else {
            return round;
        }
    }
}
