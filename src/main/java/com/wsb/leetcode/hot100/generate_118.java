package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class generate_118 {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        if (numRows == 1) {
            return res;
        }
        res.add(new ArrayList<>(List.of(1, 1)));
        if (numRows == 2) {
            return res;
        }
        int[][] dp = new int[numRows][];
        dp[0] = new int[1];
        dp[1] = new int[2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < numRows; i++) {
            dp[i] = new int[i + 1];
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < dp[i].length - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : dp[i]) {
                list.add(num);
            }
            res.add(list);
        }
        return res;
    }
}
