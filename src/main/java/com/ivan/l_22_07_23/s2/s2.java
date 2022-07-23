package com.ivan.l_22_07_23.s2;

public class s2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 存在为空直接返回
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        // 控制进位
        int flag = 0;
        int sum = 0;
        ListNode head = new ListNode(-1);
        ListNode ptr = head;

        while (l1 != null || l2 != null) {
            // 获取两个数
            int o = l1 != null ? l1.val : 0;
            int a = l2 != null ? l2.val : 0;

            // 得到结果，处理进位
            int res = (o + a + flag) % 10;
            flag = (o + a + flag) >= 10 ? 1 : 0;

            // 创建节点
            ptr.next = new ListNode(res);
            System.out.println("创建节点: " + res);
            ptr = ptr.next;

            // 移位
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        ptr.next = flag > 0 ? new ListNode(1) : null;

        return head.next;
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
