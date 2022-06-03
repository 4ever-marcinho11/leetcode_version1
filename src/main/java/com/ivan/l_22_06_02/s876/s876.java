package com.ivan.l_22_06_02.s876;

public class s876 {
    public ListNode middleNode(ListNode head) {
        // 返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
        ListNode slow = head;
        ListNode fast = head;

        // 快指针指向null的时候slow正好指向中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
