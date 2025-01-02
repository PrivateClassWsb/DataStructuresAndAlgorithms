package com.wsb.leetcode.hashtable.intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class intersection_349 {


    public static int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        // 遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        // 将结果集合转为数组
        // mapToInt(i -> i) 将流中的每个元素映射为 int 类型
        return resSet.stream().mapToInt(i -> i).toArray();

    }

    public static int[] intersection2(int[] nums1, int[] nums2){

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
            if (hash1[i] > 0 && hash2[i] > 0){
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();



    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        int[] nums2 = new int[0];
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

}


