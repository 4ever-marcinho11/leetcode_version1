package com.ivan.l_22_07_30.s1721;

import java.util.ArrayList;

public class s1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> nodeVals = new ArrayList<>();
        ListNode ptr = head;

        // 装载
        while (ptr != null) {
            nodeVals.add(ptr.val);
            ptr = ptr.next;
        }

        // 交换
        int temp = nodeVals.get(k - 1);
        nodeVals.set(k - 1, nodeVals.get(nodeVals.size() - k));
        nodeVals.set(nodeVals.size() - k, temp);

        // 组装
        ListNode front = new ListNode(-1, null);
        ptr = front;
        for (int val : nodeVals) {
            ptr.next = new ListNode(val);
            ptr = ptr.next;
        }

        return front.next;
    }

    public ListNode moreEfficiency(ListNode head, int k) {
        ListNode fast = head, slow = head;

        // 索引从1开始
        while (k > 1) {
            fast = fast.next;
            k--;
        }

        // 记录正数第k个节点
        ListNode left = fast;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 记录倒数第k个节点
        ListNode right = slow;

        // 交换
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
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
