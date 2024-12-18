package com.wsb.datastructure.recursion.singleRecursion;

public class E01Factorial {
    public static void main(String[] args) {
        int f = f(5);
        System.out.println("f = " + f);
    }
    public static int f(int n) {
        if (n == 1){
            return 1;
        }
        return n * f(n - 1);
    }

}
