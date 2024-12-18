package com.wsb.datastructure.recursion.singleRecursion;

public class E03BinarySearch {
    public static void main(String[] args) {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        int index = binarySearch(a, 44);
        System.out.println("index = " + index);
    }

    private static int binarySearch(int[] a, int target) {
        return recursion(a, target, 0, a.length - 1);
    }

    private static int recursion(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return recursion(a, target, i, m - 1);
        } else if (target > a[m]) {
            return recursion(a, target, m + 1, j);
        } else {
            return m;
        }
    }
}
