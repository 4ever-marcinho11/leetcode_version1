package com.ivan.l_22_07_28.s445;

import java.util.Stack;

public class s445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> one = new Stack<>();
        Stack<Integer> ano = new Stack<>();

        // 入栈
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            one.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            ano.push(p2.val);
            p2 = p2.next;
        }

        // 计算
        int counts = Math.min(one.size(), ano.size());
        int flag = 0;
        Stack<Integer> resStack = new Stack<>();

        while (counts > 0) {
            int sum = one.pop() + ano.pop() + flag;
            int node = sum % 10;
            flag = sum >= 10 ? 1 : 0;
            resStack.push(node);
            counts--;
        }

        // 如果两链表长度不同，继续往下计算
        int remained = Math.abs(one.size() - ano.size());
        Stack<Integer> tar = one.empty() ? ano : one;

        while (remained > 0) {
            int sum = (tar.pop() + flag);
            int node = sum % 10;
            flag = sum >= 10 ? 1 : 0;
            resStack.push(node);
            remained--;
        }

        // 生成新链表
        ListNode head = new ListNode(-1, null);
        counts = resStack.size();
        ListNode ptr = head;

        if (flag == 1) {
            ptr.next = new ListNode(flag);
            ptr = ptr.next;
        }

        while (counts > 0) {
            ptr.next = new ListNode(resStack.pop());
            ptr = ptr.next;
            counts--;
        }

        return head.next;
    }

    public ListNode moreEfficiency(ListNode l1, ListNode l2) {
        Stack<Integer> one = new Stack<>();
        Stack<Integer> ano = new Stack<>();

        // 入栈
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            one.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            ano.push(p2.val);
            p2 = p2.next;
        }

        int flag = 0;
        ListNode head = null;

        // 将计算过程进行整合，反着生成链表，减少代码量
        while (!one.empty() || !ano.empty() || flag == 1) {
            int val = flag + (one.empty() ? 0 : one.pop()) + (ano.empty() ? 0 : ano.pop());
            flag = val / 10;
            ListNode node = new ListNode(val % 10);
            node.next = head;
            head = node;
        }

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
