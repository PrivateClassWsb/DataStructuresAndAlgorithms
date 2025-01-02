package com.wsb.leetcode.hashtable.anagram;

public class isAnagram_242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));

    }

    public static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) return false;

        StringBuilder tBuilder = new StringBuilder(t);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = tBuilder.indexOf(String.valueOf(c));
            if (index == -1){
                return false;
            }else {
                tBuilder.deleteCharAt(index);
            }

        }
        return tBuilder.length() == 0;
    }

    public static boolean isAnagram2(String s, String t){

        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count :record){
            if (count != 0) return false;
        }

        return true;
    }



}
