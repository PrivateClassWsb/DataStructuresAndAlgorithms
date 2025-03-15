package com.wsb.leetcode.greedy;

public class candy_135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++) {
            candy[i] = (ratings[i] > ratings[i - 1]) ? candy[i - 1] + 1 : 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }
}
