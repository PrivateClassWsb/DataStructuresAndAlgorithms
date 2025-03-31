package com.wsb.leetcode.hot100;

import java.util.HashSet;

public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int res = 0, right = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i != 0){
                set.remove(charArray[i - 1]);
            }
            while (right < charArray.length && !set.contains(charArray[right])){
                set.add(charArray[right]);
                right++;
            }
            res = Math.max(res, right - i);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring_3 test = new lengthOfLongestSubstring_3();
        test.lengthOfLongestSubstring("abcabcbb");
    }
}
