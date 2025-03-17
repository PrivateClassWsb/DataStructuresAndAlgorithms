package com.wsb.leetcode.greedy;

public class monotoneIncreasingDigits_738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int length = s.length();
        int start = length;
        for (int i = length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]){
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.valueOf(String.valueOf(chars));
    }

    public static void main(String[] args) {
        monotoneIncreasingDigits_738 test = new monotoneIncreasingDigits_738();
        test.monotoneIncreasingDigits(1234);
    }
}
