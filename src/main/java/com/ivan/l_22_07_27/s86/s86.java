package com.ivan.l_22_07_27.s86;

import java.util.ArrayList;

public class s86 {
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> lt = new ArrayList<>();
        ArrayList<Integer> ge = new ArrayList<>();
        ListNode ptr = head;

        // 分配
        while (ptr != null) {
            if (ptr.val < x) {
                lt.add(ptr.val);
            } else {
                ge.add(ptr.val);
            }
            ptr = ptr.next;
        }

        // 组装
        ListNode front = new ListNode(-1);
        ptr = front;
        for (int i : lt) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        for (int i : ge) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        ptr.next = null;

        return front.next;
    }
}

class ListNode {
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
