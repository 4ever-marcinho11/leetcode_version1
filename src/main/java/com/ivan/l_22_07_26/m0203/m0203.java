package com.ivan.l_22_07_26.m0203;

public class m0203 {
    public void deleteNode(ListNode node) {
        // 不能遍历，就把我变成你，然后杀掉你
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
