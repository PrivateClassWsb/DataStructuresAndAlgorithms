package com.wsb.leetcode.hot100;

import java.util.ArrayList;

public class isPalindrome_234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int front = 0, back = list.size() - 1;
        while (front < back){
            if (!list.get(front).equals(list.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ArrayList<Integer> list_1 = new ArrayList<>();
        while (cur != null){
            list_1.add(cur.val);
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur = pre;
        ArrayList<Integer> list_2 = new ArrayList<>();
        while (cur != null){
            list_2.add(cur.val);
            cur = cur.next;
        }
        if (list_1.toString().equals(list_2.toString())){
            return true;
        }else {
            return false;
        }
    }
}
