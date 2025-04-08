package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations_17 {

    String[] letterMap = new String[]{
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
    };
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int num) {
        if (num == digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = letterMap[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
