package com.wsb.leetcode.stackAndQueue;

public class removeDuplicates_1047 {
    public static String removeDuplicates(String s) {

        StringBuffer sb = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && c == sb.charAt(top)) {
                sb.deleteCharAt(top);
                top--;
            }else {
                sb.append(c);
                top++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
