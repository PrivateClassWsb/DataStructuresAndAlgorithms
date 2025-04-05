package com.wsb.leetcode.hot100;

public class sortList_148 {


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


    public ListNode sortList(ListNode head) {
        // 递归终止条件：链表为空或链表只有一个节点时直接返回
        if (head == null || head.next == null){
            return head;
        }
        // 找到链表中点
        ListNode mid = findMiddle(head);
        // 从中间断开
        ListNode rightList = mid.next;
        mid.next = null;
        // 递归排序左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightList);
        return mergeTwoList(left, right);

    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return dummyNode.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
