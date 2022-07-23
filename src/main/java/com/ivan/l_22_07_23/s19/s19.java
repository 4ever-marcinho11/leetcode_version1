package com.ivan.l_22_07_23.s19;

public class s19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 前面附加一个，保证不会取到目标节点
        ListNode front = new ListNode(-1);
        front.next = head;
        ListNode ptr = front;

        // 计算长度
        int length = 0;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        // 找到倒数第n+1个
        ptr = front;
        int range = length - n - 1;
        while (range > 0) {
            ptr = ptr.next;
            range--;
        }

        // 移除目标节点
        ptr.next = ptr.next.next;

        return front.next;
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

