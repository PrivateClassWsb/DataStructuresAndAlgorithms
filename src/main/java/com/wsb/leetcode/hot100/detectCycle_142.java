package com.wsb.leetcode.hot100;

import java.util.HashSet;

public class detectCycle_142 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;

//        if (head == null || head.next == null) return null;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast){
//            if (fast == null || fast.next == null){
//                return null;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
    }
}
