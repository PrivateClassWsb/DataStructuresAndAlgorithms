package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class partition_131 {
    ArrayList<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        bachtracking(s, 0, new StringBuilder());
        return res;
    }

    private void bachtracking(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)){
                path.add(sb.toString());
                bachtracking(s, i + 1, new StringBuilder());
                path.removeLast();
            }
        }
    }

    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        partition_131 test = new partition_131();
        test.partition("aab");
    }
}
