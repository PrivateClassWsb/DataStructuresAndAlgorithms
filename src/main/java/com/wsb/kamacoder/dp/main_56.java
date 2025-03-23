package com.wsb.kamacoder.dp;

import java.util.Scanner;

public class main_56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bagWeight = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weight = new int[n];
        int[] values = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * values[i]);
                }
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
