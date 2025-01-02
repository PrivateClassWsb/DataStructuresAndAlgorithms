package com.wsb.leetcode.hashtable.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams_438 {
    public static List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 初始化窗口
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)){
            list.add(0);
        }
        // 滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)){
                list.add(i + 1);
            }
        }

        return list;

    }

    public static List<Integer> findAnagrams2(String s, String p){
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        int diff = 0;
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0){
                diff++;
            }
        }
        if (diff == 0){
            list.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // 表示当前准备移除窗口的元素
            if (count[s.charAt(i) - 'a'] == 1){ // 表示目前窗口中有该元素 而 p中没有该元素
                diff--; // 那么 当要把该元素移出去时候 就要把当前记录差值的diff-1
            }else if (count[s.charAt(i) - 'a'] == 0){ // 表示目前窗口 和 p中 都有该元素
                diff++; // 那么 当要把该元素移出去时候 就会导致窗口中没有该元素了 而p中元素不变 就要把当前记录差值的diff+1
            }
            count[s.charAt(i) - 'a']--; // 表示移除当前元素

            // 表示当前准备移入窗口的元素
            if (count[s.charAt(i + pLen) - 'a'] == -1){ // 表示准备移入窗口中的该元素 和 上面移出去的那个元素 是一样的 这样才会导致=-1
                diff--; // 此时 再把diff减回去，因为上面移出该元素时diff+1了
            }else if (count[s.charAt(i + pLen) - 'a'] == 0){ // 表示准备移入窗口中的该元素 在窗口中的数量和p中的数量是平衡的 可能都没有 也可能都有但数量一致 这样才会导致=0
                diff++; // 此时 新加入了这一个元素 就会导致不平衡 就要diff+1
            }
            count[s.charAt(i + pLen) - 'a']++; // 表示移入该元素
            if (diff == 0){
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams2(s, p);
        System.out.println(list);
    }
}
