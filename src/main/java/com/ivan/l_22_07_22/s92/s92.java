package com.ivan.l_22_07_22.s92;

public class s92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode top = new ListNode(-1);
        top.next = head;
        ListNode before = top;

        // 找到第left个节点的前一个节点
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // 反转链表Ⅰ
        ListNode pre = null;
        ListNode cur = before.next;
        int nums = right - left + 1;
        for (int i = 0; i < nums; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 链接
        before.next.next = cur;
        before.next = pre;

        return top.next;
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
