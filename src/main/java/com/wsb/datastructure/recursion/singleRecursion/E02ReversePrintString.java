package com.wsb.datastructure.recursion.singleRecursion;

public class E02ReversePrintString {
    public static void main(String[] args) {
        f(0, "abcd");
    }

    private static void f(int index, String str) {
        if (index == str.length()) {
            return;
        }
        f(index + 1, str);
        System.out.println(str.charAt(index));
    }
}
