package com.wsb.leetcode.DoublePointer.reverse_words;

public class reverseWords_151 {
    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();
        chars = removeExtraSpaces(chars);
        reverse(chars, 0, chars.length - 1);
        reverseEachWord(chars);
        return new String(chars);
    }


    public static char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0){
                    chars[slow++] = ' ';
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    public static void reverseEachWord(char[] chars){
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (chars[end] == ' ' || end == chars.length) {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" hello  world "));
    }
}
