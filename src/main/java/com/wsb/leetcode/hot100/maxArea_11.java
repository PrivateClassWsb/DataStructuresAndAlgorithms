package com.wsb.leetcode.hot100;

public class maxArea_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        int res = 0;
        while (left < right){
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(area, res);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
