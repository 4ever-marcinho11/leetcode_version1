package com.ivan.l_22_06_09.o52;

public class o52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;

        while (ptr1 != ptr2) {
            // 走一遍我走的路，再走一遍你走的路，始终会碰到一起
            ptr1 = ptr1 != null ? ptr1.next : headB;
            ptr2 = ptr2 != null ? ptr2.next : headA;
        }

        return ptr1;
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
