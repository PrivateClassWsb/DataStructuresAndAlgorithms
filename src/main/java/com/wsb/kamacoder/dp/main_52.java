package com.wsb.kamacoder.dp;

import java.util.Scanner;

public class main_52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagSize = scanner.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][bagSize + 1];
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0] + dp[0][i - weight[0]];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i][j - weight[i]]);
                }
            }
        }
        System.out.println(dp[n - 1][bagSize]);
        scanner.close();
    }
}
