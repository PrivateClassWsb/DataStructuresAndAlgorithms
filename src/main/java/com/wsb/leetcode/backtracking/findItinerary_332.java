package com.wsb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class findItinerary_332 {
    LinkedList<String> res;
    LinkedList<String> path = new LinkedList<>();
    boolean[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        used = new boolean[tickets.size()];
        backtracking(tickets);
        return res;
    }

    private boolean backtracking(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (i > 0 && tickets.get(i).get(0).equals(tickets.get(i - 1).get(0)) && tickets.get(i).get(1).equals(tickets.get(i - 1).get(1)) && !used[i - 1]) {
                continue;
            }
            if (tickets.get(i).get(0).equals(path.getLast()) && !used[i]) {
                path.add(tickets.get(i).get(1));
                used[i] = true;
                if (backtracking(tickets)) {
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
