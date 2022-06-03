package com.ivan.l_22_06_02.s142;

public class s142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 在相遇处退出，此时fast与slow指向一个位置
            if (fast == slow) {
                // 让slow指向head，fast指向刚刚的相遇处，以同速前进
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // 再次相遇的位置就是环的起点
                return slow;
            }
        }

        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
