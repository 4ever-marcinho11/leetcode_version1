package com.ivan.l_22_07_26.m0206;

public class m0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 快慢指针找到链表中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转从slow开始的链表
        ListNode headSub = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = headSub;
            headSub = slow;
            slow = next;
        }

        // 以反转后的链表为模板与原链表解析
        while (headSub != null) {
            if (headSub.val != head.val) {
                return false;
            }
            head = head.next;
            headSub = headSub.next;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
