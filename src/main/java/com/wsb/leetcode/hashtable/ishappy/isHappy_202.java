package com.wsb.leetcode.hashtable.ishappy;

import java.util.HashSet;

public class isHappy_202 {

    public static boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;

    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
