package com.wsb.leetcode.hot100;

public class reverseKGroup_25 {


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


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while(head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode[] listNodes = myReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
