package com.ivan.l_22_07_24.o18;

public class o18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode front = new ListNode(-1);
        front.next = head;

        if (head == null) {
            return null;
        }

        ListNode prev = front;
        ListNode curr = head;

        while (curr != null && curr.val != val) {
            prev = prev.next;
            curr = curr.next;
        }

        prev.next = prev.next.next;

        return front.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
