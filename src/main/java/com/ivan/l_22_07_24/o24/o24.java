package com.ivan.l_22_07_24.o24;

public class o24 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        if (head == null) {
            return null;
        }

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
