package com.ivan.l_22_07_20.s203;

public class s203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode front = head, current = head;

        // 首先判断头节点是否需要清除
        while (front != null && front.val == val) {
            front = front.next;
            current = current.next;
        }

        // 依旧为空直接返回
        if (front == null) {
            return null;
        }

        ListNode pre = current;
        current = current.next;

        // 使用current清除链表中的节点
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                current = pre.next;
            } else {
                pre = current;
                current = current.next;
            }
        }

        return front;
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
