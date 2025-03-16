package com.wsb.leetcode.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class partitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] edge = new int[26];
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(edge[chars[i] - 'a'], idx);
            if (idx == i){
                list.add(idx - last);
                last = idx;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        partitionLabels_763 test = new partitionLabels_763();
        test.partitionLabels("ababcbacadefegdehijhklij");
    }
}
