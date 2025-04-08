package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis_22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2){
            res.add(sb.toString());
            return;
        }
        if (open < n){
            sb.append('(');
            backtrack(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open){
            sb.append(')');
            backtrack(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis_22 test = new generateParenthesis_22();
        test.generateParenthesis(3);
    }
    public List<String> generateParenthesis1(int n) {
        generateAll(new char[2 * n], 0);
        return res;
    }

    private void generateAll(char[] chars, int pos) {
        if (pos == chars.length){
            if (valid(chars)){
                res.add(new String(chars));
            }
        }else {
            chars[pos] = '(';
            generateAll(chars, pos + 1);
            chars[pos] = ')';
            generateAll(chars, pos + 1);
        }

    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '('){
                balance++;
            }else if (c == ')'){
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }
}
