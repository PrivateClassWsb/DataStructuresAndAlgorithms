package com.wsb.algorithm.kmp;

public class strStr_28 {

    public int strStr1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();

        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while(b < m && s[a] == t[b]){
                a++;
                b++;
            }
            if(b == m){
                return i;
            }
        }

        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();

        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needleCharArray[i] != needleCharArray[j]) {
                j = next[j - 1];
            }
            if (needleCharArray[i] == needleCharArray[j]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, a = 0; i < haystack.length(); i++) {
            while (a > 0 && needleCharArray[a] != haystackCharArray[i]) {
                a = next[a - 1];
            }
            if (needleCharArray[a] == haystackCharArray[i]) {
                a++;
            }
            if (a == needle.length()) {
                return i - a + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abeababeabf";
        String needle = "abeabf";
        strStr2(haystack, needle);
    }
}
