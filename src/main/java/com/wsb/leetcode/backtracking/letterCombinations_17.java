package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations_17 {

    List<String> res = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder temp = new StringBuilder();
//    digits = "23"
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return res;
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int num) {
        if (num == digits.length()){
            res.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(digits, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
