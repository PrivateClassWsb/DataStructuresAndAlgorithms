package com.wsb.leetcode.greedy;

import java.util.Arrays;

public class findContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]){
                start++;
                count++;
            }
        }
        return count;
    }

    public int findContentChildren1(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int start = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0 && start >= 0; i--) {
            if (s[start] >= g[i]){
                start--;
                count++;
            }
        }
        return count;
    }
}
