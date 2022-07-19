package com.ivan.l_22_07_19.s160;

public class s160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (true) {
            if (p1 == p2) {
                return p1;
            }

            // a链走完，去b链
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // b链走完，去a链
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
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