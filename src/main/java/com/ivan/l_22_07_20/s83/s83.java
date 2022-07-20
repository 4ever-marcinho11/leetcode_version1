package com.ivan.l_22_07_20.s83;

public class s83 {
    public ListNode deleteDuplicates(ListNode head) {
        // 空
        if (head == null) {
            return null;
        }

        // 只有一个节点
        if (head.next == null) {
            return head;
        }

        ListNode pred = head, succ = head.next;
        while (pred != null && succ != null) {
            if (pred.val == succ.val) {
                succ = succ.next;
                pred.next = succ;
            } else {
                pred = pred.next;
                succ = succ.next;
            }
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
