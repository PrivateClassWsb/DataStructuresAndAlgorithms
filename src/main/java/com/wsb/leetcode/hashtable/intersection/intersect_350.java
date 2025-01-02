package com.wsb.leetcode.hashtable.intersection;

import java.util.ArrayList;
import java.util.Arrays;

public class intersect_350 {

    public static int[] intersect1(int[] nums1, int[] nums2){

        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];

        for (int i : nums1) {
            hash1[i]++;
        }

        for (int i : nums2) {
            hash2[i]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1002; i++) {
            if (hash1[i] != 0){
                if (hash1[i] == hash2[i]){
                    for (int j = 0; j < hash1[i]; j++) {
                        list.add(i);
                    }
                }
                if (hash1[i] != hash2[i]){
                    int min = Math.min(hash1[i], hash2[i]);
                    for (int j = 0; j < min; j++) {
                        list.add(i);
                    }
                }
            }

        }

        return list.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect1(nums1, nums2)));
    }

}


