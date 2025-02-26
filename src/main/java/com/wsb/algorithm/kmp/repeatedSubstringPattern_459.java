package com.wsb.algorithm.kmp;

public class repeatedSubstringPattern_459 {
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern1(String s) {

        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }

        if (next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("abac"));
    }

}
