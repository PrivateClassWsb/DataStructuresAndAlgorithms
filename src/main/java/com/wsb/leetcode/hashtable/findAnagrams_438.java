package com.wsb.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 初始化窗口
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)){
            list.add(0);
        }
        // 滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)){
                list.add(i + 1);
            }
        }

        return list;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
}
