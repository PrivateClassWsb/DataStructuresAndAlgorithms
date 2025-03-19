package com.wsb.kamacoder.dp;

import java.util.Scanner;

public class main_46 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][bagweight + 1];
        for (int j = weights[0]; j <= bagweight ; j++) {
            dp[0][j] = values[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagweight; j++) {
                if (j < weights[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - weights[i]]);
                }
            }
        }
        System.out.println(dp[n - 1][bagweight]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        int[] dp = new int[bagweight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagweight; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        System.out.println(dp[bagweight]);
    }
}
