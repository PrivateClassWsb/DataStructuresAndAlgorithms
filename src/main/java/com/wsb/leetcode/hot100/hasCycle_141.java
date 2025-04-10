package com.wsb.leetcode.hot100;

import java.util.HashSet;

public class hasCycle_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (!set.add(cur)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
