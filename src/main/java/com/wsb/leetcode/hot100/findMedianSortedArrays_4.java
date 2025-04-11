package com.wsb.leetcode.hot100;

public class findMedianSortedArrays_4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1){
                int midIndex = totalLength / 2;
                double res = getKthElement(nums1, nums2, midIndex + 1);
                return res;
            }else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double res = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return res;
            }
        }

        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较。
                                    即，分别取nums1和nums2的第k/2小的元素（因为数组从0开始，所以要-1）
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
        */
        public int getKthElement(int[] nums1, int[] nums2, int k) {
            int index1 = 0, index2 = 0;
            int length1 = nums1.length, length2 = nums2.length;
            while (true){
                if (index1 == length1){
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2){
                    return nums1[index1 + k - 1];
                }
                if(k == 1){
                    return Math.min(nums1[index1], nums2[index2]);
                }
                int half = k / 2;
                // 可能越界
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int temp1 = nums1[newIndex1], temp2 = nums2[newIndex2];
                if (temp1 <= temp2){
                    // 如果 A[k/2−1] 或者 B[k/2−1] 越界，那么我们选取在上述newIndex处选取了对应数组中的最后一个元素。
                    // 在这种情况下，我们必须根据排除数的个数减少 k 的值，而不能直接将 k 减去 k/2。
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                }else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }


}
