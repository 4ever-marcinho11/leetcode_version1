package com.ivan.l_22_07_21.s1290;

import java.util.ArrayList;

public class s1290 {
    public int getDecimalValue(ListNode head) {
        // 找到长度
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }

        // 填充数组
        ArrayList<Integer> list = new ArrayList<>();
        int base = 1;
        for (int i = 0; i < len; i++) {
            list.add(base);
            base *= 2;
        }

        // 获取二进制字符串
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val);
            head = head.next;
        }

        // 二进制转十进制
        String bin = s.toString();
        int dec = 0;
        for (int i = 0; i < len; i++) {
            if (bin.charAt(i) == '1') {
                dec += list.get(len - i - 1);
            }
        }

        return dec;
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
