package com.ivan.l_22_06_08.s206;

public class s206 {
    public ListNode reverseList(ListNode head) {
        // 空表直接返回
        if (head == null) {
            return null;
        }

        // 得到总节点数
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        // 依次放到数组中
        ListNode[] list = new ListNode[count];
        ptr = head;
        for (int i = 0; i < count && ptr != null; i++) {
            list[i] = ptr;
            ptr = ptr.next;
        }

        // 交换，只考虑前一半（0到中间偏左）
        for (int i = 0; i < count / 2; i++) {
            int mir = count - i - 1;
            int temp = list[i].val;
            list[i].val = list[mir].val;
            list[mir].val = temp;
        }

        // 生成新链表
        ptr = list[0];
        ListNode newHead = list[0];
        for (int i = 1; i < list.length; i++) {
            ptr.next = list[i];
            ptr = ptr.next;
        }

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
