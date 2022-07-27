package com.ivan.l_22_07_27.s61;

public class s61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 重置k值，使得 0 <= k < length
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        // 不需要旋转，直接返回
        if (k == 0 || k % length == 0) {
            return head;
        }
        k %= length;

        // 找到倒数第k+1个节点
        int count = k;
        ListNode first = head;
        while (count > 0) {
            first = first.next;
            count--;
        }

        // 找到中断点
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // 记录这两个节点
        ListNode newEnd = second, newHead = second.next;

        // 组装
        newEnd.next = null;
        ListNode conn = newHead;
        while (conn.next != null) {
            conn = conn.next;
        }
        conn.next = head;

        return newHead;
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
