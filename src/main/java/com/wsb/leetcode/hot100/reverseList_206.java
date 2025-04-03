package com.wsb.leetcode.hot100;

public class reverseList_206 {
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
    // 递归
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode curr) {
        if (curr == null){
            return pre;
        }
        ListNode next = curr.next;
        curr.next = pre;
        return reverse(curr, next);
    }

    // 双指针法
    public ListNode reverseList1(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}
