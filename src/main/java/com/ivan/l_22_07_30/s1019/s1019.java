package com.ivan.l_22_07_30.s1019;

import java.util.ArrayList;
import java.util.Stack;

public class s1019 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        // 放到集合里
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        // 下一个更大元素——单调栈
        Stack<Integer> s = new Stack<>();
        int l = array.length;
        int[] result = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            // 栈中只留最大的
            while (!s.empty() && s.peek() <= array[i]) {
                s.pop();
            }

            result[i] = s.empty() ? 0 : s.peek();
            s.push(array[i]);
        }

        return result;
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
