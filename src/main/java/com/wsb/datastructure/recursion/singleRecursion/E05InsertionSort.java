package com.wsb.datastructure.recursion.singleRecursion;

import java.util.Arrays;

public class E05InsertionSort {
    public static void main(String[] args) {

        int[] a = {3, 2, 6, 1, 5, 4, 7};
        insertion(a, 1, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void insertion(int[] a, int low, int high) {
        if (low > high){
            return;
        }
        int t = a[low];
        int i = low - 1;
        while(i >= 0 && a[i] > t){
            a[i + 1] = a[i];
            i--;
        }
        if (i + 1 != low){
            a[i + 1] = t;
        }
        insertion(a, low + 1, high);
    }


}
