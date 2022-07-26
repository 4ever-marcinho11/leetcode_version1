package com.ivan.l_22_07_26.m0201;

import java.util.HashSet;

public class m0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> existed = new HashSet<>();
        ListNode front = new ListNode(-1);
        front.next = head;
        ListNode prev = front, ptr = head;

        while (ptr != null) {
            if (existed.contains(ptr.val)) {
                prev.next = ptr.next;
                ptr = prev.next;
            } else {
                existed.add(ptr.val);
                prev = ptr;
                ptr = ptr.next;
            }
        }

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

