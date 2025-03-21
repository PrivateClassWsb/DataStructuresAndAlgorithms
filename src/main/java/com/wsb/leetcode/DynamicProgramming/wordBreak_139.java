package com.wsb.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class wordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]){
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }

    public static void main(String[] args) {
        wordBreak_139 test = new wordBreak_139();
        ArrayList<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        test.wordBreak("leetcode", wordDict);
        wordDict.add("apple");
        wordDict.add("pen");
        test.wordBreak("applepenapple", wordDict);
    }
}
