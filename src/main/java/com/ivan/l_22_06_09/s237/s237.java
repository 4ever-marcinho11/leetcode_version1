package com.ivan.l_22_06_09.s237;

public class s237 {
    public void deleteNode(ListNode node) {
        // 无法访问链表的头节点，只能访问被删除的节点
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
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