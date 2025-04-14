package com.wsb.algorithm.quickSort;

import com.google.errorprone.annotations.Var;

import java.util.Arrays;

// 落母拖分区
public class lomuto {

    private static void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(nums, left, right); //基准点索引
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int i = left;
        int j = left;
        while (j < right){
            if (nums[j] < pivot){
                if (j != i){
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
