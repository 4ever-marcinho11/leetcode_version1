package com.ivan.l_22_07_30.s725;

import java.util.Arrays;

public class s725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }

        // 获取分配策略
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        int[] strategy = new int[k];
        if (length <= k) {
            for (int i = 0; i < length; i++) {
                strategy[i] = 1;
            }
        } else {
            // 赋初值
            int def = length / k;
            Arrays.fill(strategy, def);

            // 调整策略
            int rem = length % k;
            for (int i = 0; i < rem; i++) {
                strategy[i]++;
            }
        }

        // 截断
        ListNode[] res = new ListNode[k];
        ptr = head;
        for (int i = 0; i < strategy.length; i++) {
            if (strategy[i] == 0) {
                continue;
            }
            // 把第一个节点放入结果数组
            res[i] = ptr;

            // 找到最后一个节点
            int count = 1;
            while (count < strategy[i]) {
                ptr = ptr.next;
                count++;
            }

            // 截断并让ptr指向下一个
            if (ptr != null) {
                ListNode next = ptr.next;
                ptr.next = null;
                ptr = next;
            }
        }

        return res;
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
