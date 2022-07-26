package com.ivan.l_22_07_26.m0202;

public class m0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;

        if (head == null) {
            return -1;
        }

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
