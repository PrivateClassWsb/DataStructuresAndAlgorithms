package com.wsb.leetcode.CharacterString.reverseString;

public class reverseString_344 {

    public void reverseString1(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseString2(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++;
            j--;
        }
    }

}
