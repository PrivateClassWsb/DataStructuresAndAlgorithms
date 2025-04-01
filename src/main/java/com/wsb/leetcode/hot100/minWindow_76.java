package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class minWindow_76 {
    HashMap<Character, Integer> tMap = new HashMap<>();
    HashMap<Character, Integer> sMap = new HashMap<>();
    public String minWindow(String s, String t) {

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int resLeft = -1, resRight = -1;
        int l = 0;
        int len = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            if (tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check()){
                if (r - l + 1 < len){
                    len = r - l + 1;
                    resLeft = l;
                    resRight = l + len;
                }
                if (tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resRight);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
