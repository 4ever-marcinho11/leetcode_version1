package com.ivan.l_22_07_25.o6;

import java.util.ArrayList;

public class o6 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


        ArrayList<Integer> arrayList = new ArrayList<>();
        while (pre != null) {
            arrayList.add(pre.val);
            pre = pre.next;
        }

        return arrayList.stream().mapToInt((one) -> {
            return one;
        }).toArray();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
