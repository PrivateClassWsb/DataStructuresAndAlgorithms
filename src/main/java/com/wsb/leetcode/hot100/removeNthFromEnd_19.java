package com.wsb.leetcode.hot100;

public class removeNthFromEnd_19 {


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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        int target = length - n + 1;
        for (int i = 1; i < target; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyNode.next;
    }
}
