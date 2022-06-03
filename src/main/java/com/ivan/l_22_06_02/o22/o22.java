package com.ivan.l_22_06_02.o22;


public class o22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        // 要倒数第几个就先走几步
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        // 之后以同速前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 慢指针指向的元素就是倒数第几个元素
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