package com.wsb.leetcode.hashtable.anagram;

public class canConstruct_383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct2(ransomNote, magazine));
    }

    private static boolean canConstruct1(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;

        StringBuilder stringBuilder = new StringBuilder(ransomNote);

        for (int i = 0; i < magazine.length(); i++) {
            for (int j = 0; j < stringBuilder.length(); j++) {
                if (magazine.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                    break;
                }
            }
        }

        if (stringBuilder.length() == 0){
            return true;
        }else {
            return false;
        }
    }

    private static boolean canConstruct2(String ransomNote, String magazine){

        int[] record = new int[26];

        if (ransomNote.length() > magazine.length()) return false;

        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }

        for (char c :ransomNote.toCharArray()) {
            record[c - 'a']--;
        }

        for (int i : record) {
            if (i < 0 ){
                return false;
            }
        }
        return true;
    }

}
