package com.ivan.l_22_07_27.s24;

public class s24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ptr = head;
        while (ptr != null) {
            int temp = ptr.val;
            if (ptr.next == null) {
                break;
            }
            ptr.val = ptr.next.val;
            ptr.next.val = temp;
            ptr = ptr.next.next;
        }

        return head;
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
