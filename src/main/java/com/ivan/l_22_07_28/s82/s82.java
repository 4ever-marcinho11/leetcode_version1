package com.ivan.l_22_07_28.s82;

import java.util.HashMap;

public class s82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode ptr = head;

        // 建立映射
        while (ptr != null) {
            if (map.containsKey(ptr.val)) {
                map.put(ptr.val, map.get(ptr.val) + 1);
            } else {
                map.put(ptr.val, 1);
            }
            ptr = ptr.next;
        }

        // 降低冗余
        ListNode front = new ListNode(-1);
        front.next = head;
        ListNode left = front, right = front.next;

        while (right != null) {
            if (map.get(right.val) == 1) {
                // 不删除
                left = left.next;
            } else {
                // 删除
                left.next = right.next;
            }
            right = right.next;
        }

        return front.next;
    }

    public ListNode fasterButLarger(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode front = new ListNode(0, head);
        ListNode cur = front;

        // 从头遍历
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 删除当前节点后所有相同的节点
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

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
