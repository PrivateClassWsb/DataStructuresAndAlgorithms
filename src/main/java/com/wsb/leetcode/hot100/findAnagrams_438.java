package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) res.add(0);
        for (int i = 0; i < s.length() - p.length(); i++) {
            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(sArray, pArray)) res.add(i + 1);
        }
        return res;
    }
}
