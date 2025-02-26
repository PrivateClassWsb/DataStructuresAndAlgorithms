package com.wsb.algorithm.kmp;

public class nextArray {

    public static void getNext(int[] next, String s){
        int j = 0;
        next[0] = 0;
        char[] ch = s.toCharArray();
        for(int i = 1; i < ch.length; i++) { // 注意i从1开始
            while (j > 0 && ch[i] != ch[j]) { // 前后缀不相同了
                j = next[j - 1]; // 向前回退
            }
            if (ch[i] == ch[j]) { // 找到相同的前后缀
                j++;
            }
            next[i] = j; // 将j（前缀的长度）赋给next[i]
        }
    }

    public static void main(String[] args) {
        String s = "aabaaf";
        int[] next = new int[s.length()];
        getNext(next,s);
    }
}

// a b e a b a b e a b f
// a b e a b f