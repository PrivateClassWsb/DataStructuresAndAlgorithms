package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int[] edge = new int[26]; // 记录字符串中的每个字母在字符串中出现的最后一个位置
        for (int i = 0; i < charArray.length; i++) {
            edge[charArray[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < charArray.length; i++) {
            idx = Math.max(edge[charArray[i] - 'a'], idx); // 记录遍历过的字符的最远位置
            if (idx == i){
                res.add(idx - last);
                last = idx;
            }
        }
        return res;
    }
}
