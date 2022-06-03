package com.ivan.l_22_06_02.s141;

public class s141 {
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针的方式判断是否成环
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 如果成环，两个指针一定会相遇
            if (fast == slow) {
                return true;
            }
        }
        return false;
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
